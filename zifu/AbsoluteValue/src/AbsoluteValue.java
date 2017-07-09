class AbsoluteValue {
	private double Value;

	AbsoluteValue() {
		Value = 0;
	
	}

	/*
	 * @ requires true
	 *
	 * ensures \result == this.Value || \result == 0 - this.Value
*/
	protected void SetValue(double Value) {
		this.Value = Value;
	}
	
	AbsoluteValue(double Value) {
		this.Value = Value;
	}
}

class ABS {
	public static double GetAbs(double Value) {
		return Value >= 0 ? Value : 0 - Value;
	}
}

class AbsoluteValueTest {
	public static double Abs(double Value) {
		return Value >= 0 ? Value : 0 - Value;
	}

	public static void main(String[] args) {
		assert (8.0 == Abs(8.0));
		assert (8.0 == Abs(-8.0));
		assert (0.0 == Abs(0.0));

		assert (8.0 == ABS.GetAbs(8.0));
		assert (8.0 == ABS.GetAbs(-8.0));
		assert (0.0 == ABS.GetAbs(0.0));

		AbsoluteValue Result = new AbsoluteValue(8.0);
		assert (8.0 == Result.GetValue());

		AbsoluteValue Result1 = new AbsoluteValue(-8.0);
		AbsoluteValue Result2 = new AbsoluteValue(0.0);

		assert (8.0 == Result.GetValue());
		Result.SetValue(-5.0);
		assert (5.0 == Result.GetValue());
		Result.SetValue(0.0);
		assert (0.0 == Result.GetValue());
	}
}
