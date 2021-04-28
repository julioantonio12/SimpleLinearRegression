import java.util.Scanner;

public class SimpleLinearRegression {
	private static double b0;
	private static double b1;

	public static double makePrediction(double inputValue) {
		return b0 + b1 * inputValue;
	}

	public static void calculateBeta(double[] dataSetX, double[] dataSetY) {
		double sumX=0, sumY=0, sumXSquare = 0, acum1 = 0, acum2 = 0, averageX = 0, averageY = 0;
		int n = dataSetX.length;
		for (int i=0; i < n; i++) {
			sumX += dataSetX[i];
			sumY += dataSetY[i];
			// sumXY = sumXY + (dataSetX[i] * dataSetY[i]);
		}
		averageX = sumX / n;
		averageY = sumY / n;
		for (int i = 0; i < n; i++) {
			acum1 += ((dataSetX[i] - averageX) * (dataSetY[i] - averageY));
			acum2 += (dataSetX[i] - averageX) * (dataSetX[i] - averageX);
		}
		
		// sumXSquare = Math.pow(sumX, 2);
		// b1 = ((n * sumXY) - (sumX * sumY)) / ((n * sumXSquare) - sumXSquare);
		b1 = acum1 / acum2;
		b0 = averageY - ((b1) * (sumX)/n);
		System.out.println(String.format("Regression equation: Yest = %.4f + %.4f * x", b0, b1));
		System.out.println(String.format("b1 = %.4f", b1));
		System.out.println(String.format("b0 = %.4f", b0));
	}

	public static void main(String args[]) {
		double dataX;
		Scanner sc = new Scanner(System.in);
		double dataSetX[] = {23, 26, 30, 34, 43, 48, 52, 57, 58};
		double dataSetY[] = {
			651,
			762,
			856,
			1063,
			1190,
			1298,
			1421,
			1440,
			1518
		};
		SimpleLinearRegression simpleLinearRegression = new SimpleLinearRegression();
		simpleLinearRegression.calculateBeta(dataSetX, dataSetY);
		System.out.println("Predecir: ");
		dataX = sc.nextDouble();
		System.out.println(String.format("%.4f", simpleLinearRegression.makePrediction(dataX)));
		sc.close();
	}
}