package projecteuler.P31;

public class Ex31 {
	public static void main(String args[]) {
		int count = 0;
		for (int a = 0; a <= 200; a++) {
			for (int b = 0; b <= 100; b++) {
				for (int c = 0; c <= 40; c++) {
					for (int cc = 0; cc <= 20; cc++) {
						for (int d = 0; d <= 10; d++) {
							for (int e = 0; e <= 4; e++) {
								for (int f = 0; f <= 2; f++) {
									for (int g = 0; g <= 1; g++) {
										if (a * 1 + b * 2 + c * 5 + cc * 10 + d * 20 + e * 50 + f * 100
												+ g * 200 == 200)
											count++;
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println(count);

	}

}
