package view.server;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import dao.PersonDAO;
import util.Constant;
import util.CustomerHandler;
import util.PersonType;
import util.StatisticalEmployeeHandler;
import util.storageEvents.StorageEmployeeHandler;

public class PnlServerLog extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JButton btnConnect;
	private JButton btnInterrupt;
	private ServerSocket serverSocket;
	private Thread serverThread;
	private JTextArea textArea;
	private ArrayList<Thread> clients = new ArrayList<>();

	/**
	 * Create the panel.
	 */
	public PnlServerLog() {
		setLayout(new BorderLayout(0, 0));

		textArea = new JTextArea();
		add(textArea, BorderLayout.CENTER);

		JPanel pnlOptions = new JPanel();
		add(pnlOptions, BorderLayout.SOUTH);

		btnConnect = new JButton("Kết nối server");
		pnlOptions.add(btnConnect);

		btnInterrupt = new JButton("Ngắt kết nối");
		btnInterrupt.setEnabled(false);
		pnlOptions.add(btnInterrupt);

		btnConnect.addActionListener(this);
		btnInterrupt.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnConnect)) {
			if (serverSocket != null && !serverSocket.isClosed()) {
				textArea.append("Server was ran\n");
			}
			btnConnect.setEnabled(false);
			btnInterrupt.setEnabled(true);

			startServer();
		}

		if (o.equals(btnInterrupt)) {
			btnConnect.setEnabled(true);
			btnInterrupt.setEnabled(false);
//			stop all client that still connect to serversocket
			for (Thread client : clients) {
				if (client.isAlive()) {
					client.interrupt();
				}
			}
			serverThread.interrupt();
			if (serverSocket != null && !serverSocket.isClosed()) {
				try {
					serverSocket.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			textArea.append("Server was stopped\n");

		}
	}

	private void startServer() {
		serverThread = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					serverSocket = new ServerSocket(Constant.PORT, 50);
					textArea.append("Server is running at port 8603\n");
					boolean isRunning = true;
					ExecutorService executor = Executors.newFixedThreadPool(10);
					
					
					while (isRunning) {
						Socket accept = null;
						try {
							textArea.append("\n\nwaiting for client");
							accept = serverSocket.accept();
							textArea.append("Client connected");
							textArea.append("Client " + accept.getInetAddress() + " connecting\n");
							ObjectOutputStream oos = new ObjectOutputStream(accept.getOutputStream());
							ObjectInputStream ois = new ObjectInputStream(accept.getInputStream());
							PersonType type = (PersonType) ois.readObject();
							textArea.append("Client " + accept.getInetAddress() + " connected\n");
							Runnable handler = null;
							if (type == PersonType.CUSTOMER) {
								handler = new CustomerHandler(accept,ois,oos);
								textArea.append("Customer connected\n");
							}
							else if (type == PersonType.STORAGE_EMPLOYEE) {
								 handler = new StorageEmployeeHandler(accept,ois,oos);
								 textArea.append("Storage employee connected\n");
							}
							else if(type == PersonType.STATISCAL_EMPLOYEE) {
								handler = new StatisticalEmployeeHandler(accept, ois, oos);
								textArea.append("Statistical employee connected\n");
							}

//							Thread thread = new Thread(handler);
//							clients.add(thread);
//							thread.start();
							executor.submit(handler);

						} catch (IOException e) {
							isRunning = false;
						}
					}

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		serverThread.start();
	}

}
