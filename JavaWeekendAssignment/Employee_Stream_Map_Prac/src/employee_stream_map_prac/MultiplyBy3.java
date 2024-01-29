package employee_stream_map_prac;

import java.util.List;

public class MultiplyBy3 {

	public static void main(String[] args) {
		List<Integer> values = List.of(1,2,3,4,5,6,7);
		List<Integer> list2 = values.stream().map(i -> i*3).toList();
		
		System.out.println(list2);
	}
}
