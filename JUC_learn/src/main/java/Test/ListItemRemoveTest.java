package Test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ListItemRemoveTest {
	public List<String> initList = Arrays.asList("alibaba","baidu","bytedance","bilibili");

	/**
	 * for 循环删除
	 *
	 */

	@Test
	public void test1(){
		List<String> initList = Arrays.asList("alibaba","baidu","bytedance","bilibili");
		List<String> list = new ArrayList<>(initList);
		for(String element : list){
			if(element.startsWith("b")){
				list.remove(element);
			}
		}
		System.out.println(list);

//		java.lang.UnsupportedOperationException
//		at java.util.AbstractList.remove(AbstractList.java:161)
//		at java.util.AbstractList$Itr.remove(AbstractList.java:374)
//		at java.util.AbstractCollection.remove(AbstractCollection.java:293)
	}

	@Test
	public void test2(){
		List<String> initList = Arrays.asList("alibaba","baidu","bytedance","bilibili");
		List<String> list = new ArrayList<>(initList);
		list.forEach(o->{
			if(o.startsWith("b")){
				list.remove(o);
			}
		});
		System.out.println(list);
//		java.util.ConcurrentModificationException
//		at java.util.ArrayList.forEach(ArrayList.java:1262)
//		at Test.ListItemRemoveTest.test2(Test.ListItemRemoveTest.java:36)
	}

	@Test
	public void test3(){
		List<String> initList = Arrays.asList("alibaba","baidu","bytedance","bilibili");
		List<String> list = new ArrayList<>(initList);

		for(int i=0;i<list.size();i++){
			if(list.get(i).startsWith("b"))
				list.remove(i);
		}
		System.out.println(list);
	}

	@Test
	public void test4(){
		List<String> initList = Arrays.asList("alibaba","baidu","bytedance","bilibili");
		List<String> list = new ArrayList<>(initList);

		for(int i=list.size()-1;i>=0;i--){
			if(list.get(i).startsWith("b"))
				list.remove(i);
		}
		System.out.println(list);
	}

	@Test
	public void test5(){
		List<String> initList = Arrays.asList("alibaba","baidu","bytedance","bilibili");
		List<String> list = new ArrayList<>(initList);

		for(Iterator<String> iterator=list.iterator();iterator.hasNext();){
			String str = iterator.next();
			if(str.startsWith("b"))
				iterator.remove();
		}
		//等价于
		list.removeIf(str -> str.startsWith("b"));
		System.out.println(list);
	}

	@Test
	public void test6(){
		List<String> initList = Arrays.asList("alibaba","baidu","bytedance","bilibili");
		List<String> list = new ArrayList<>(initList);
		list=list.stream().filter(o->!o.startsWith("b")).collect(Collectors.toList());
		System.out.println(list);
	}
}
