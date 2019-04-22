public final class raiseToAPower {
	static long temp = 0;
	public static long raiseToAPower(long raise, int toPowerOf){
		if (toPowerOf == 0)return 1;

		if(toPowerOf == 1){
			raise = temp;
			temp = 0;
			return raise;
		}

		if (temp == 0) temp = raise;

		temp *= raise;
		return raiseToAPower(raise, toPowerOf-1);
	}
}
