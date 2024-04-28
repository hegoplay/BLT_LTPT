package view.server;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import util.Constant;
import util.CustomerHandler;
import util.PersonType;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class PnlServerLog extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JButton btnConnect;
	private JButton btnInterrupt;
	private ServerSocket serverSocket;
	private Thread serverThread;
	private JTextArea textArea;
	private ArrayList<Runnable> clients = new ArrayList<>();
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
			btnConnect.setEnabled(false);
			btnInterrupt.setEnabled(true);
			startServer();
		}
		
		if (o.equals(btnInterrupt)) {
			btnConnect.setEnabled(true);
			btnInterrupt.setEnabled(false);
//			stop all client that still connect to serversocket
			for (Runnable client : clients) {
                Thread t = (Thread) client;
                t.interrupt();
            }
			serverThread.interrupt();
		}
	}
	
	private void startServer() {
		serverThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					serverSocket = new ServerSocket(Constant.PORT,50);
					textArea.append("Server is running at port 8603\n");
					while (true) {
						Socket accept = serverSocket.accept();
						ObjectInputStream ois = new ObjectInputStream(accept.getInputStream());
						PersonType type = (PersonType) ois.readObject();
						Runnable handler = null;
						if(type == PersonType.CUSTOMER) {
							handler = new CustomerHandler(accept);
						}
						clients.add(handler);
						textArea.append("Client " + accept.getInetAddress() + "connected\n");
						new Thread(handler).start();
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
