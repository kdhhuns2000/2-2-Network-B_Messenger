package Example;

import function.Encrypt;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;


// test_user_1
// 00000000-0000-0000-0000-000000000001

// test_user_2
// 00000000-0000-0000-0000-000000000002

// test_user_3
// 00000000-0000-0000-0000-000000000003
public class Example_API {
    public static void main(String[] args) {
//        try {
//            JSONObject json = new JSONObject();
//            json.put("command", "CREATE_ROOM");
//            json.put("access-token", "00000000-0000-0000-0000-000000000001");
//
//            JSONArray invite_user_list = new JSONArray();
//            invite_user_list.put("test_user_2");
//            invite_user_list.put("test_user_3");
//
//            json.put("userlist", invite_user_list);
//
////            json.put("access-token", "00000000-0000-0000-0000-000000000001");
//            Socket socket = new Socket("localhost", 35014);
//            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//
//            out.write(json.toString());
//            out.newLine();
//            out.flush();
//
//            while(true){
//                String response_str = in.readLine();
//
//                if(response_str == null){
//                    Thread.sleep(10);
//                    continue;
//                }
//                JSONObject response = new  JSONObject(response_str);
//
//                System.out.println("response: " + response);
//            }
//
//        } catch (Exception ex) {
//            throw new RuntimeException(ex);
//        }
        try {
            JSONObject json = new JSONObject();
            json.put("command", "SEARCH");
            json.put("search_keyword", "도");
            Socket socket = new Socket("localhost", 35014);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));


            out.write(json.toString());
            out.newLine();
            out.flush();

            String response_str = in.readLine();

            JSONObject response = new JSONObject(response_str);

            System.out.println("response: " + response);

            JSONArray searchList = response.getJSONArray("body");

            System.out.println(searchList);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void login(){
        try {
            JSONObject json = new JSONObject();
            json.put("command", "LOGIN");
            json.put("id", "test_user_2");
            json.put("password", "test_password");
//            json.put("access-token", "00000000-0000-0000-0000-000000000001");
            Socket socket = new Socket("localhost", 35014);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.write(json.toString());
            out.newLine();
            out.flush();

            while(true){
                String response_str = in.readLine();

                if(response_str == null){
                    Thread.sleep(10);
                    continue;
                }
                JSONObject response = new  JSONObject(response_str);

                System.out.println("response: " + response);
            }

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void get_friend_list(){
        try {
            JSONObject json = new JSONObject();
            json.put("command", "GET_FRIENDS");
            json.put("access-token", "00000000-0000-0000-0000-000000000001");
            Socket socket = new Socket("localhost", 35014);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));


            out.write(json.toString());
            out.newLine();
            out.flush();

//
//            int attempts = 0;
//            while(!in.ready() && attempts < 1000)
//            {
//                attempts++;
//                Thread.sleep(10);
//            }

            String response_str = in.readLine();

            JSONObject response = new JSONObject(response_str);

            System.out.println("response: " + response);

            JSONArray friendList = response.getJSONArray("body");

            System.out.println(friendList);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void get_user_info(){
        try {
            JSONObject json = new JSONObject();
            json.put("command", "GET_USER_INFO");
            json.put("access-token", "00000000-0000-0000-0000-000000000001");
            Socket socket = new Socket("localhost", 35014);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.write(json.toString());
            out.newLine();
            out.flush();
//
//            int attempts = 0;
//            while(!in.ready() && attempts < 1000)
//            {
//                attempts++;
//                Thread.sleep(10);
//            }

            String response_str = in.readLine();

            JSONObject response = new JSONObject(response_str);

            System.out.println("response: " + response);

            JSONObject userInfo = response.getJSONObject("body");

            System.out.println(userInfo);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void get_chat_list(){
        try {
            JSONObject json = new JSONObject();
            json.put("command", "GET_USER_ROOM");
            json.put("access-token", "00000000-0000-0000-0000-000000000001");
            Socket socket = new Socket("localhost", 35014);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));


            out.write(json.toString());
            out.newLine();
            out.flush();

            String response_str = in.readLine();

            JSONObject response = new JSONObject(response_str);

            System.out.println("response: " + response);

            JSONObject roomsJson = response.getJSONObject("body");

            System.out.println(roomsJson);

            Map<String, Object> room_map = roomsJson.toMap();

            System.out.println(room_map);

            for(Map.Entry<String, Object> room : room_map.entrySet()){
                System.out.println(room.getKey());

                System.out.println(roomsJson.get(room.getKey()));
                JSONArray room_arr = roomsJson.getJSONArray(room.getKey());

                for (int i=0; i < room_arr.length(); i++) {
                    System.out.println(room_arr.get(i));
                }

            }

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void add_friend(){
        try {
            JSONObject json = new JSONObject();
            json.put("command", "ADD_FRIEND");
            json.put("id", "");
            json.put("name", "");
            Socket socket = new Socket("localhost", 35014);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.write(json.toString());
            out.newLine();
            out.flush();

            String response_str = in.readLine();

            JSONObject response = new JSONObject(response_str);

            int status = response.getInt("status");
            String body = response.getString("body");

            System.out.println("Status : " + status);
            System.out.println("body : " + body);

            JOptionPane.showOptionDialog(null, "친구추가 완료", "알림",
                    JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{"닫기"}, "닫기");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void get_search_result(){
        try {
            JSONObject json = new JSONObject();
            json.put("command", "SEARCH");
            json.put("search_key", "도");
            Socket socket = new Socket("localhost", 35014);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));


            out.write(json.toString());
            out.newLine();
            out.flush();

            String response_str = in.readLine();

            JSONObject response = new JSONObject(response_str);

            System.out.println("response: " + response);

            JSONArray searchList = response.getJSONArray("body");

            System.out.println(searchList);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
