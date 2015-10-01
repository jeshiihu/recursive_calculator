import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

// Notes:
// Cases 4,5,6 dont work (returns error or 0)
// Exception Cases do not work either

public class calculator{
	static boolean answerFound = false;
	
	static int add(int a, int b) {
		int ans = a+b;
		return ans;
	}
	static int sub(int a, int b) {
		int ans = a-b;
		return ans;
	}
	static int mult(int a, int b) {
		int ans = a*b;
		return ans;
	}
	static int div(int a, int b) {
		int ans = a/b;
		return ans;
	}
	static int pow(int a, int b) {
		int ans = a;
		for (int x=2; x<=b; x++){
			ans *= a;
		}
		return ans;
	}
	
	public class SyntaxException extends Exception{
		public SyntaxException(){
			super("Error in syntax: illegal/ missing character");
		}
	}
	public class RuntimeException extends Exception{
		public RuntimeException(){
			super("Error in runtime: identifier with no value");
		}
	}


	
	public static int doMath(String expr, HashMap<String, Integer> hmap) {
		String compute = "";
		Pattern pattern;
		Matcher matcher;
//		System.out.println(expr);
		
//		try {
			if(expr.length()==1) {
				return Integer.parseInt(expr);
			} 
//				else {
//				throw new SyntaxException();
//			}
//		} catch(SyntaxException e){
//			System.out.println("Syntax Error");
//		}

			pattern = Pattern.compile("\\(.+$\\)");
			matcher = pattern.matcher(expr);
			if(matcher.find()) {
				
			pattern = Pattern.compile(".\\s\\^\\s.");
			matcher = pattern.matcher(expr);
			if(matcher.find()) {
				compute = matcher.group(0);
				String[] exprChar = compute.split(" ");
				if(exprChar[0].matches("\\d")) {
					if(exprChar[2].matches("\\d")) {
						int a = Integer.parseInt(exprChar[0]);
						int b = Integer.parseInt(exprChar[2]);
						expr = expr.replaceFirst(".\\s\\^\\s.", Integer.toString(calculator.pow(a,b)));
						return doMath(expr,hmap);
					}
					if(exprChar[2].matches("\\w")) {
						int a = Integer.parseInt(exprChar[0]);
						int b = hmap.get(exprChar[2]);
						expr = expr.replaceFirst(".\\s\\^\\s.", Integer.toString(calculator.pow(a,b)));
						return doMath(expr,hmap);
					}
				}
				else {
					if(exprChar[2].matches("\\d")) {
						int a = hmap.get(exprChar[0]);
						int b = Integer.parseInt(exprChar[2]);
						expr = expr.replaceFirst(".\\s\\^\\s.", Integer.toString(calculator.pow(a,b)));
						return doMath(expr,hmap);
					}
					if(exprChar[2].matches("\\w")) {
						int a = hmap.get(exprChar[0]);
						int b = hmap.get(exprChar[2]);
						expr = expr.replaceFirst(".\\s\\^\\s.", Integer.toString(calculator.pow(a,b)));
						return doMath(expr,hmap);
					}
				}
			}
			}
			
			pattern = Pattern.compile(".\\s\\*\\s.");
			matcher = pattern.matcher(expr);
			if(matcher.find()) {
				compute = matcher.group(0);
				String[] exprChar = compute.split(" ");
				if(exprChar[0].matches("\\d")) {
					if(exprChar[2].matches("\\d")) {
						int a = Integer.parseInt(exprChar[0]);
						int b = Integer.parseInt(exprChar[2]);
						expr = expr.replaceFirst(".\\s\\*\\s.", Integer.toString(calculator.mult(a,b)));
						return doMath(expr,hmap);
					}
					if(exprChar[2].matches("\\w")) {
						int a = Integer.parseInt(exprChar[0]);
						int b = hmap.get(exprChar[2]);
						expr = expr.replaceFirst(".\\s\\*\\s.", Integer.toString(calculator.mult(a,b)));
						return doMath(expr,hmap);
					}
				}
				else {
					if(exprChar[2].matches("\\d")) {
						int a = hmap.get(exprChar[0]);
						int b = Integer.parseInt(exprChar[2]);
						expr = expr.replaceFirst(".\\s\\*\\s.", Integer.toString(calculator.mult(a,b)));
						return doMath(expr,hmap);
					}
					if(exprChar[2].matches("\\w")) {
						int a = hmap.get(exprChar[0]);
						int b = hmap.get(exprChar[2]);
						expr = expr.replaceFirst(".\\s\\*\\s.", Integer.toString(calculator.mult(a,b)));
						return doMath(expr,hmap);
					}
				}
			}
			
			pattern = Pattern.compile(".\\s\\+\\s.");
			matcher = pattern.matcher(expr);
			if(matcher.find()) {
				compute = matcher.group(0);
				String[] exprChar = compute.split(" ");
				if(exprChar[0].matches("\\d")) {
					if(exprChar[2].matches("\\d")) {
						int a = Integer.parseInt(exprChar[0]);
						int b = Integer.parseInt(exprChar[2]);
						expr = expr.replaceFirst(".\\s\\+\\s.", Integer.toString(calculator.add(a,b)));
						return doMath(expr,hmap);
					}
					if(exprChar[2].matches("\\w")) {
						int a = Integer.parseInt(exprChar[0]);
						int b = hmap.get(exprChar[2]);
						expr = expr.replaceFirst(".\\s\\+\\s.", Integer.toString(calculator.add(a,b)));
						return doMath(expr,hmap);
					}
				}
				else {
					if(exprChar[2].matches("\\d")) {
						int a = hmap.get(exprChar[0]);
						int b = Integer.parseInt(exprChar[2]);
						expr = expr.replaceFirst(".\\s\\+\\s.", Integer.toString(calculator.add(a,b)));
						return doMath(expr,hmap);
					}
					if(exprChar[2].matches("\\w")) {
						int a = hmap.get(exprChar[0]);
						int b = hmap.get(exprChar[2]);
						expr = expr.replaceFirst(".\\s\\+\\s.", Integer.toString(calculator.add(a,b)));
						return doMath(expr,hmap);
					}
				}
				
			}
			
			pattern = Pattern.compile(".\\s\\-\\s.");
			matcher = pattern.matcher(expr);
			if(matcher.find()) {
				compute = matcher.group(0);
				String[] exprChar = compute.split(" ");
				if(exprChar[0].matches("\\d")) {
					if(exprChar[2].matches("\\d")) {
						int a = Integer.parseInt(exprChar[0]);
						int b = Integer.parseInt(exprChar[2]);
						expr = expr.replaceFirst(".\\s\\-\\s.", Integer.toString(calculator.sub(a,b)));
						return doMath(expr,hmap);
					}
					if(exprChar[2].matches("\\w")) {
						int a = Integer.parseInt(exprChar[0]);
						int b = hmap.get(exprChar[2]);
						expr = expr.replaceFirst(".\\s\\-\\s.", Integer.toString(calculator.sub(a,b)));
						return doMath(expr,hmap);
					}
				}
				else {
					if(exprChar[2].matches("\\d")) {
						int a = hmap.get(exprChar[0]);
						int b = Integer.parseInt(exprChar[2]);
						expr = expr.replaceFirst(".\\s\\-\\s.", Integer.toString(calculator.sub(a,b)));
						return doMath(expr,hmap);
					}
					if(exprChar[2].matches("\\w")) {
						int a = hmap.get(exprChar[0]);
						int b = hmap.get(exprChar[2]);
						expr = expr.replaceFirst(".\\s\\-\\s.", Integer.toString(calculator.sub(a,b)));
						return doMath(expr,hmap);
					}
				}
		} else {

			pattern = Pattern.compile(".\\s\\^\\s.");
			matcher = pattern.matcher(expr);
			if(matcher.find()) {
				compute = matcher.group(0);
				String[] exprChar = compute.split(" ");
				if(exprChar[0].matches("\\d")) {
					if(exprChar[2].matches("\\d")) {
						int a = Integer.parseInt(exprChar[0]);
						int b = Integer.parseInt(exprChar[2]);
						expr = expr.replaceFirst(".\\s\\^\\s.", Integer.toString(calculator.pow(a,b)));
						return doMath(expr,hmap);
					}
					if(exprChar[2].matches("\\w")) {
						int a = Integer.parseInt(exprChar[0]);
						int b = hmap.get(exprChar[2]);
						expr = expr.replaceFirst(".\\s\\^\\s.", Integer.toString(calculator.pow(a,b)));
						return doMath(expr,hmap);
					}
				}
				else {
					if(exprChar[2].matches("\\d")) {
						int a = hmap.get(exprChar[0]);
						int b = Integer.parseInt(exprChar[2]);
						expr = expr.replaceFirst(".\\s\\^\\s.", Integer.toString(calculator.pow(a,b)));
						return doMath(expr,hmap);
					}
					if(exprChar[2].matches("\\w")) {
						int a = hmap.get(exprChar[0]);
						int b = hmap.get(exprChar[2]);
						expr = expr.replaceFirst(".\\s\\^\\s.", Integer.toString(calculator.pow(a,b)));
						return doMath(expr,hmap);
					}
				}
			}
			
			pattern = Pattern.compile(".\\s\\*\\s.");
			matcher = pattern.matcher(expr);
			if(matcher.find()) {
				compute = matcher.group(0);
				String[] exprChar = compute.split(" ");
				if(exprChar[0].matches("\\d")) {
					if(exprChar[2].matches("\\d")) {
						int a = Integer.parseInt(exprChar[0]);
						int b = Integer.parseInt(exprChar[2]);
						expr = expr.replaceFirst(".\\s\\*\\s.", Integer.toString(calculator.mult(a,b)));
						return doMath(expr,hmap);
					}
					if(exprChar[2].matches("\\w")) {
						int a = Integer.parseInt(exprChar[0]);
						int b = hmap.get(exprChar[2]);
						expr = expr.replaceFirst(".\\s\\*\\s.", Integer.toString(calculator.mult(a,b)));
						return doMath(expr,hmap);
					}
				}
				else {
					if(exprChar[2].matches("\\d")) {
						int a = hmap.get(exprChar[0]);
						int b = Integer.parseInt(exprChar[2]);
						expr = expr.replaceFirst(".\\s\\*\\s.", Integer.toString(calculator.mult(a,b)));
						return doMath(expr,hmap);
					}
					if(exprChar[2].matches("\\w")) {
						int a = hmap.get(exprChar[0]);
						int b = hmap.get(exprChar[2]);
						expr = expr.replaceFirst(".\\s\\*\\s.", Integer.toString(calculator.mult(a,b)));
						return doMath(expr,hmap);
					}
				}
			}
			
			pattern = Pattern.compile("\\(.+\\s\\+\\s.\\)");
			matcher = pattern.matcher(expr);
			if(matcher.find()) {
				compute = matcher.group(0);
				String[] exprChar = compute.split(" ");
				if(exprChar[0].matches("\\d")) {
					if(exprChar[2].matches("\\d")) {
						int a = Integer.parseInt(exprChar[0]);
						int b = Integer.parseInt(exprChar[2]);
						expr = expr.replaceFirst(".\\s\\+\\s.", Integer.toString(calculator.add(a,b)));
						return doMath(expr,hmap);
					}
					if(exprChar[2].matches("\\w")) {
						int a = Integer.parseInt(exprChar[0]);
						int b = hmap.get(exprChar[2]);
						expr = expr.replaceFirst(".\\s\\+\\s.", Integer.toString(calculator.add(a,b)));
						return doMath(expr,hmap);
					}
				}
				else {
					if(exprChar[2].matches("\\d")) {
						int a = hmap.get(exprChar[0]);
						int b = Integer.parseInt(exprChar[2]);
						expr = expr.replaceFirst(".\\s\\+\\s.", Integer.toString(calculator.add(a,b)));
						return doMath(expr,hmap);
					}
					if(exprChar[2].matches("\\w")) {
						int a = hmap.get(exprChar[0]);
						int b = hmap.get(exprChar[2]);
						expr = expr.replaceFirst(".\\s\\+\\s.", Integer.toString(calculator.add(a,b)));
						return doMath(expr,hmap);
					}
				}
				
			}
			
			pattern = Pattern.compile(".\\s\\-\\s.");
			matcher = pattern.matcher(expr);
			if(matcher.find()) {
				compute = matcher.group(0);
				String[] exprChar = compute.split(" ");
				if(exprChar[0].matches("\\d")) {
					if(exprChar[2].matches("\\d")) {
						int a = Integer.parseInt(exprChar[0]);
						int b = Integer.parseInt(exprChar[2]);
						expr = expr.replaceFirst(".\\s\\-\\s.", Integer.toString(calculator.sub(a,b)));
						return doMath(expr,hmap);
					}
					if(exprChar[2].matches("\\w")) {
						int a = Integer.parseInt(exprChar[0]);
						int b = hmap.get(exprChar[2]);
						expr = expr.replaceFirst(".\\s\\-\\s.", Integer.toString(calculator.sub(a,b)));
						return doMath(expr,hmap);
					}
				}
				else {
					if(exprChar[2].matches("\\d")) {
						int a = hmap.get(exprChar[0]);
						int b = Integer.parseInt(exprChar[2]);
						expr = expr.replaceFirst(".\\s\\-\\s.", Integer.toString(calculator.sub(a,b)));
						return doMath(expr,hmap);
					}
					if(exprChar[2].matches("\\w")) {
						int a = hmap.get(exprChar[0]);
						int b = hmap.get(exprChar[2]);
						expr = expr.replaceFirst(".\\s\\-\\s.", Integer.toString(calculator.sub(a,b)));
						return doMath(expr,hmap);
					}
				}
			}
		
		}
		return 0;
	}
	

	public static int getOperator(String expr, HashMap<String, Integer> hmap,int prevNum, int prevHmapLen) {
		String compute = "";
		int ans = 0;
		int num =0;
		
		while(!answerFound) {
		Pattern pattern = Pattern.compile("\\(let\\s\\w\\s=\\s\\d\\)"); //brac = int
		Matcher matcher = pattern.matcher(expr);
		if(matcher.find()){
		    compute = matcher.group(0);
			String[] eqv = compute.replaceAll("\\(let|\\)|\\s|=", "").split("");
			num = Integer.parseInt(eqv[1]);
			hmap.put(eqv[0], num);
			expr = expr.replaceFirst("\\(let\\s\\w\\s=\\s\\d\\)", eqv[1]);
			
			return getOperator(expr,hmap,num,hmap.size());
		}
		pattern = Pattern.compile("\\(let\\s\\w\\s=\\s\\w\\)"); //brac = var
		matcher = pattern.matcher(expr);
		if(matcher.find()){
		    compute = matcher.group(0);
			String[] eqv = compute.replaceAll("\\(let|\\)|\\s|=", "").split("");
			num = hmap.get(eqv[1]);
			hmap.put(eqv[0], num);
			expr = expr.replaceFirst("\\(let\\s\\w\\s=\\s\\d\\)", eqv[1]);
			
			return getOperator(expr,hmap,num,hmap.size());
		}
		
		pattern = Pattern.compile("let\\s\\w\\s=\\s$\\d"); //no brac = int
		matcher = pattern.matcher(expr);
		if(matcher.find()){
		    compute = matcher.group(0);
			String[] eqv = compute.replaceAll("let|\\s|=", "").split("");
			num = Integer.parseInt(eqv[1]);
			hmap.put(eqv[0], num);
			expr = expr.replaceFirst("let\\s\\w\\s=\\s\\d", eqv[1]);
			return getOperator(expr,hmap,num,hmap.size());
		}
//		pattern = Pattern.compile("\\(let\\s\\w\\s=\\s.+\\)"); //no brac = int
//		matcher = pattern.matcher(expr);
//		if(matcher.find()){
//		    compute = matcher.group(0);
//			String[] eqv = compute.replaceAll("\\s", "").split("");
//			num = doMath(expr,hmap);
//			hmap.put(eqv[0], num);
//			expr = expr.replaceFirst("let\\s\\w\\s=\\s\\d", eqv[1]);
//			return getOperator(expr,hmap,num,hmap.size());
//		}
		else {
			ans = doMath(expr, hmap);
			answerFound = true;
			System.out.println("Answer: " + ans);
			return ans;
		}
		}
		return ans;
	}



	public static void main(String[] args) {
		HashMap<String,Integer> hmap = new HashMap<String, Integer>();
		System.out.println("Enter your mathematical expression: ");
		Scanner scanner = new Scanner(System.in);
		String expr = scanner.nextLine();
		scanner.close();
		getOperator(expr, hmap, 1,0);

	}
}