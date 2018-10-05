package com.bcopstein.ExpressionCalculator;

public class Expression {
	public static int evaluate(String expression) {
		String tokens[] = expression.split("(?<=\\+)|(?=\\+)|(?<=\\-)|(?=\\-)");

		int primeiro = 0;
		int result = 0;
		try {
			// Trata o sinal inicial
			String aux = tokens[primeiro];
			if (aux.equals("-")) {
				primeiro++;
				result -= Integer.parseInt(tokens[primeiro]);
				primeiro++;
			} else if (aux.equals("+")) {
				primeiro++;
				result += Integer.parseInt(tokens[primeiro]);
				primeiro++;
			} else {
				result += Integer.parseInt(aux);
				primeiro++;
			}

			// Trata a sequencia
			for (int i = primeiro; i < tokens.length; i += 2) {
				switch (tokens[i]) {
				case "+":
					result += Integer.parseInt(tokens[i + 1]);
					break;
				case "-":
					result -= Integer.parseInt(tokens[i + 1]);
					break;
				}
			}
		} catch (RuntimeException e) {
			throw new InvalidExpressionException(e);
		}
		return result;
	}
}
