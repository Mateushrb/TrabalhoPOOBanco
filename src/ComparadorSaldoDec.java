
public class ComparadorSaldoDec {
		public int compare(Conta c1, Conta c2) {
			if (c1.getSaldo() < c2.getSaldo()) {
				return -1;
			}
			if (c1.getSaldo() > c2.getSaldo()) {
				return 1;
			}
			return 0;
		}
	
}
