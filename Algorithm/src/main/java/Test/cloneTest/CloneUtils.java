package Test.cloneTest;
import java.io.*;

/**
 * 通过字节流序列化实现深拷贝，需要深拷贝的对象必须实现Serializable接口
 *
 * @author Administrator
 */



class Account implements Serializable,Cloneable {
	private static final long serialVersionUID = -444218284294850002L;
	public int id;
	public double count;
	long test;
	long hht;

	public Account(int id, double count,long test) {
		this.id = id;
		this.count = count;
		this.test=test;

	}

	@Override
	protected Account clone() {
		try {
			return (Account) super.clone();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
}

class Person implements Serializable,Cloneable{
	private static final long serialVersionUID = 1108939236459677238L;
	String name;
	int age;
	Account account;
	long mm;

	@Override
	protected Person clone()  {
		try {
			Person person = (Person) super.clone();
			person.account = account.clone();
			return person;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}


	public Person(String name, int age, Account account) {
		this.name = name;
		this.age = age;
		this.account=account;
	}
}
public class CloneUtils {
	@SuppressWarnings("unchecked")
	public static <T extends Serializable> T clone(T obj) {
		T cloneObj = null;
		try {
			// 写入字节流
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			ObjectOutputStream obs = new ObjectOutputStream(out);
			obs.writeObject(obj);
			obs.close();

			// 分配内存，写入原始对象，生成新对象
			ByteArrayInputStream ios = new ByteArrayInputStream(out.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(ios);
			// 返回生成的新对象
			cloneObj = (T) ois.readObject();
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cloneObj;
	}

	public static void writeTXT(Account account) throws IOException {

		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("user.txt"));
		objectOutputStream.writeObject(account);
		objectOutputStream.close();

	}

	public static void readObj() {
		try {
			ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("user.txt"));
			try {
				Object object = objectInputStream.readObject();
				Account user = (Account) object;

				System.out.println(user);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		Person p1=new Person("Test.hhh",22,new Account(1,1,1L));
		//Serializable
		Person p2=CloneUtils.clone(p1);
		System.out.println(p1+" "+p1.hashCode()+" "+Integer.toHexString(p1.hashCode())+" "+p1.name+" "+p1.age+" "+" ||account:"+p1.account+" "+p1.account.id+" "+p1.account.count+" "+p1.mm);
		System.out.println(p2+" "+p2.hashCode()+" "+Integer.toHexString(p2.hashCode())+" "+p2.name+" "+p2.age+" "+" ||account:"+p2.account+" "+p2.account.id+" "+p2.account.count+" "+p1.mm);
		//Cloneable
		//可以看到，以这种方式拷贝后，User对象跟之前的不一样，属于深拷贝，
		// 但Account对象还是之前的对象，并没有实现深拷贝，
		// 所以，super.clone()仅能保证当前对象是深拷贝的，
		// 但无法保证内部对象的深拷贝，仅仅调用super.clone()是无法实现深拷贝的。
		// 要想实现对象的完全深拷贝，需要对象内的所有成员对象都继承Cloneable接口，实现clone()方法，并进行赋值。

		Person p3=p1.clone();
		System.out.println(p3+" "+p3.hashCode()+" "+Integer.toHexString(p3.hashCode())+" "+p3.name+" "+p3.age+" "+" ||account:"+p3.account+" "+p3.account.id+" "+p3.account.count+" "+p1.mm);

		try {
			writeTXT(p1.account);
		} catch (IOException e) {
			e.printStackTrace();
		}

		readObj();


	}
}
