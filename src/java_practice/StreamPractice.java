package java_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPractice {
	
	public static void main(String[] args) {
		//streams from java8
		//more efficient , parallel operations, lamda functions
		//streams can e created from Collections, arrays, files 
		
		// intermediate operations or terminal operations
		// source -> filter,map,sort -> collect,foreach,reduce
		
		// filter,map,sort return stream
		//terminal - non stream , reduce to list 
		
		//anymatch, distinct , filter , findfirst , flatmap, map, sorted, skip
		//foreach - 
		//collect - to collection
		//count max , min , reduce, summarystatistics, reduce
		
		IntStream.range(1, 10).forEach(System.out::println);
		
		System.out.println();
		
		IntStream.range(1, 10).skip(5).forEach(x->System.out.println(x));

		IntStream.range(1,20).forEach(System.out::println);
		
		System.out.println();
		
		System.out.println(IntStream.range(1, 5).sum());
		
		System.out.println();
		
		Stream.of("avin","ajith","abc").sorted().findFirst().ifPresent(System.out::println);

		ArrayList<Integer> salaryList = new ArrayList<>();
		salaryList.add(1000);
		salaryList.add(100);
		salaryList.add(2000);

		System.out.println("salary greater than for x members :" + salaryList.stream().filter((s)->s>500).count());

		//streams can be created from collection

		Stream<Integer> s1 = salaryList.stream();

		//Streams can be created from arrays

		Integer[] salary = {3,2,4,5,6};

		Stream<Integer> s2 = Arrays.stream(salary);

		Stream<Integer> s3 = Stream.of(3,2,4,5,6);

		Stream<Object> s4 = Stream.builder().add(3).add(3).build();

		//filter- filter element

		Stream<String> highCase = Stream.of("HELLO","HOW","ARE","YOU");
		List<String> ab = highCase.filter(s->s.length()<=3).collect(Collectors.toList());
		System.out.println(ab);

		//transform each element
		highCase = Stream.of("HELLO","HOW","ARE","YOU");
		List<String> lowerCase =highCase.map(String ::toLowerCase).toList();
		System.out.println(lowerCase);

		//flatmap

		List<List<String>> listofList = Arrays.asList(
				Arrays.asList("hi","there","how"),
				Arrays.asList("are","u","doing"),
				Arrays.asList("wasssup","bro")
		);

		//used to iterate over complex collection and flatten it
		Stream<String> stringStream = listofList.stream().flatMap(lis -> lis.stream());

		System.out.println(stringStream.toList());

		Stream<String> stringStream1 = listofList.stream().flatMap(lis -> lis.stream().map(String::toUpperCase));

		System.out.println(stringStream1.toList());

		Integer[] arr = {1,0,2,42,7,3,9,4,1};

		System.out.println(Arrays.stream(arr).skip(2).sorted().toList());

		System.out.println(Arrays.stream(arr).sorted((v1,v2)->v2-v1).toList());

		System.out.println(Arrays.stream(arr).distinct().toList());

		//helps to see intermediate operations

		Arrays.stream(arr).filter(x->(x%2==0)).peek(y->System.out.println(y)).map(z->z*2).toList();

		//limit size to 3

		//skip skip first n elements

		// stream is lazy only when terminal operator is executed

		//stream operation when chained execute for element till opertaion which requires all the elements

		//terminal operations

		//foreach performs on each element
		Arrays.stream(arr).filter(x->(x%2==0)).forEach(System.out::println);

		//to array, to list
		Arrays.stream(arr).filter(x->(x%2==0)).toArray();

		//reduce assocaite aggregate function

		System.out.println(Arrays.stream(arr).filter(x->(x%2==0)).reduce(Integer::sum).get());

		//collector collect to list
		//.collect(colllectos.tolist())

		//min max count anymatch find any

		// once stream is closed by terminal operation it closed

		//parallel stream

		//operation concurantly








	}

}
