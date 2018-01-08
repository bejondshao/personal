package org.bejond.wholetest.stackoverflow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.IntPredicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class StreamAPI {

	public static void main(String[] args) {

		int n = 1000;
		Supplier<IntStream> intStreamSupplier = () -> IntStream.range(2, n).filter(new IntPredicate() {

			ArrayList<Integer> prev = new ArrayList<>();

			@Override
			public boolean test(int value) {

				for ( int i = 0; i < prev.size(); i++ )
				{
					if ( value % prev.get(i) == 0 )
					{
						return false;
					}
				}
				prev.add(value);
				return true;
			}
		});

		Map<Integer, IntStream> map = new HashMap<>();

		for ( int i = 0; i < n; i += 100 )
		{
			int j = i;
			IntStream subStream = intStreamSupplier.get().filter(new IntPredicate() {

				@Override public boolean test(int value) {

					if ( j < value && value < ( j + 100 ) )
					{
						return true;
					}
					return false;
				}
			});

			map.put(i, subStream);
		}

		for ( Map.Entry<Integer, IntStream> entry : map.entrySet() )
		{
			Integer key = entry.getKey();
			IntStream value = entry.getValue();

			System.out.println("key: " + key);
			int[] arr = value.toArray();
			for ( int i = 0; i < arr.length; i++ )
			{
				System.out.println(arr[i]);
			}
		}
	}
}
