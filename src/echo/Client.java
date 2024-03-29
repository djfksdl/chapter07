package echo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client { // 기본샘플

	public static void main(String[] p) throws IOException {
		// 통신이 목적이라 키자마자 소켓 만들어낼거임
		Socket socket = new Socket();

		System.out.println("<클라이언트 시작>");
		System.out.println("===============");
		System.out.println("서버에 연결을 요청합니다.");

		socket.connect(new InetSocketAddress("192.168.0.43", 10001)); 
		
		System.out.println("서버에 연결되었습니다.");

		// 메세지 내보내기

		// 메세지 보내기용 스트림
		OutputStream os = socket.getOutputStream(); 
		OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);
	

		// 메세지 받기용 스트림
		InputStream is = socket.getInputStream();
		InputStreamReader isw = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(isw);

		// 반복(/q라고하면 끝내기)

		// +키보드 입력
		// 스캐너준비
		 Scanner sc = new Scanner(System.in);// 외부인 키보드랑 연결하는것

		while (true) {
			
			//키보드입력
			String str = sc.nextLine();

			if (str.equals("/q")) { 
				break;
			}
			// 메세지 보내기
			bw.write(str);
			bw.newLine();
			bw.flush();

			// 메세지 받기용
			String reMsg = br.readLine();
			System.out.println("server:[ " + reMsg + " ]");
		}

		System.out.println("====================================");
		System.out.println("<클라이언트 종료>");


		// 닫기- 이게 반복되면 다 끝나버림
		sc.close(); 
		br.close();
		bw.close();
		socket.close();

	}
}
