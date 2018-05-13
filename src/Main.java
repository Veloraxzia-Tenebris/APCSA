public class Main
{
	public static void main(String args[])
	{
		System.out.println("memes");
	}
}

public class Lesson_12_FastStart
{
	public static void main(String args[])
	{
		ArrayList<String> list = new ArrayList<String>();
list.add("apple");
list.add("mom");
list.add("cat");
list.add("alien");
list.add("mouse");
list.add("robot");
list.add("teacher");
list.add("computer");
list.add("sound");
list.add("website");
        for(int i = 0; i < 2; i++)
		System.out.print(list.get((int) (Math.random() * list.size())));
	}
}