package com.data.structures.challanges;

public class HorizonTest {

	public static void main(String[] args) {
		String arg = args[1].substring(1, args[1].length() - 1);
		String[] array = arg.split(",");
		HorizonTest t = new HorizonTest();
		t.getHorizon(Integer.parseInt(args[0]), array);
	}

	private String[] getHorizon(int input1, String[] input2)
	{
		int[][] co_ordinates = new int[input1][3];
		for (int i = 0; i < input1; i++) {
			co_ordinates[i][0] = Integer.parseInt(input2[i].split("#")[0]);
			co_ordinates[i][1] = Integer.parseInt(input2[i].split("#")[1]);
			co_ordinates[i][2] = Integer.parseInt(input2[i].split("#")[2]);
		}
		int smallest = co_ordinates[0][0];
		int largest = co_ordinates[0][2];
		for (int i = 0; i < co_ordinates.length; i++) {
			for (int j = i + 1; j < co_ordinates.length; j++) {
				if (smallest > co_ordinates[j][0])
					smallest = co_ordinates[j][0];
				if (largest < co_ordinates[j][2])
					largest = co_ordinates[j][2];
			}
		}
		int[][] array = new int[largest][3];
		array[smallest][0] = 0;
		String buffer = smallest + "#" + array[smallest][0] + ",";
		for (int i = smallest; i < largest; i++) {
			if (isPresent(i, co_ordinates)) {
				array[i][1] = findMaxHeight(i, co_ordinates);
				buffer = buffer.concat(i + "#" + array[i][1] + ",");
			}
		}
		array[largest - 1][0] = 0;
		buffer = buffer.concat(largest + "#" + array[largest - 1][0]);
		System.out.println(buffer);
		return buffer.split(",");
	}

	private boolean isPresent(int length, int[][] co_ordinates) {
		boolean present = false;
		for (int i = 0; i < co_ordinates.length; i++) {
			if (co_ordinates[i][0] == length)
				present = true;
		}
		return present;
	}

	private int findMaxHeight(int smallest, int[][] co_ordinates) {
		int max = 0;
		for (int i = 0; i < co_ordinates.length; i++) {
			if (co_ordinates[i][0] == smallest && max < co_ordinates[i][1])
				max = co_ordinates[i][1];
		}
		return max;
	}

}
