package echo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server { //기본샘플

	public static void main(String[] args) throws IOException{  

		//서버소켓생성
		ServerSocket serverSocket = new ServerSocket();
		
		//바인딩
		serverSocket.bind(new InetSocketAddress("192.168.0.29", 10001)); 

		
		//서버시작
		System.out.println("<서버시작>");
		System.out.println("==================");

		//반복
		while(true) {
			
			System.out.println("[연결을 기다리고 있습니다.]");
			
			Socket socket = serverSocket.accept();
			
			//출장 thread.start()
			
			Thread thread = new ServerThread(socket); //소켓번호 알려주고 나가!라함 위에있는 소켓 들고 출장 가게 됨. 출장가는데는 필요없는데 출장가서 메세지 주고받는데는 필요하다. 
			thread.start();//13:17 스타트인지 소켓인지?
		}
		
		/*	남아있으면 오류나니까 꺼버림
		System.out.println("=======================");
		System.out.println("<서버종료>");
		
		//닫기
		bw.close(); 
		br.close();
		socket.close();
		serverSocket.close();*/
		
		//이게 홈페이지에서 돌아가는 프로그램임
		
		
	}

}
