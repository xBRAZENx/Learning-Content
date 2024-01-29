package employee_stream_map_prac;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DisplayDuplicates {

	public static void main(String[] args) {
        List<String> list1 = List.of("1", "2", "3", "4","5","6");
        List<String> list2 = List.of("1", "2", "3", "4");
        List<String> duplicates = list1.stream().filter(list2::contains).toList();
        System.out.println("Duplicates: " + duplicates);
    }
}
