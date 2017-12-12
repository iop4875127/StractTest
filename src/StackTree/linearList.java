package StackTree;

/**
 * Created by Andrew_wl on 2017/11/13.
 */
/*
* 链表的合并。
* 如果链表userA中存在链表userB的元素，那舍去，否则添加到链表userB中。
* */

import java.util.*;

public class linearList {

	static ArrayList<User> userA = new ArrayList<User>();

	static ArrayList<User> userB = new ArrayList<User>();

	static int la;

	static int lb;

	//	将两个集合中的用户合并在一起
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//链表A
		addUser();

		//链表B
		addUsers();

		//AB并集
		union();
	}

	static void addUser(){



		User one = new User();
		one.id = 1;
		one.name = "张三";
		one.password= "aaa";
		one.sex = "男";

		User two = new User();
		two.id = 2;
		two.name = "李四";
		two.password= "bbb";
		two.sex = "女";

		userA.add(one);
		userA.add(two);

		System.out.println(userA.size());
	}

	static void addUsers(){



		User three = new User();
		three.id = 2;
		three.name = "麻五";
		three.password= "fff";
		three.sex = "男";

		User one = new User();
		one.id = 3;
		one.name = "王五";
		one.password= "ccc";
		one.sex = "男";

		User two = new User();
		two.id = 4;
		two.name = "柳六";
		two.password= "ddd";
		two.sex = "女";

		userB.add(three);
		userB.add(one);
		userB.add(two);

		System.out.println(userB);
	}

	//AB并集
	static void union(){

		la = userA.size();
		lb = userB.size();
		for( int i = 0; i < la; i++){
			if(compare(userA.get(i))){
				System.out.println("集合B中存在该元素");
			}else {
				userB.add(userA.get(i));
			}
		}
		System.out.println(userB);
	};

	//遍历集合是否存在该元素
	static boolean compare(User user){

		for( int k = 0; k < lb; k++){

			if(user.getId() == userB.get(k).getId()){
				return true;
			}
		}
		return false;


	}

	//栈的几个常用操作
	static void stackTest(){
		Stack<String> stack = new Stack<String>();
		String s1 = "element 1";
		String s2 = "element 2";
		stack.push(s1);
		stack.push(s2);
		
		//输出栈顶
		System.out.println(stack.peek());

		//	输出元素位置
		int pos = stack.search("element 1");
		System.out.println(pos);

		//	输出被移除的元素--》栈顶元素
		System.out.println(stack.pop());
		System.out.println(stack.pop());

		//	输出布尔类型的判断空栈
		System.out.println(stack.empty());
	}
	
	 
}
