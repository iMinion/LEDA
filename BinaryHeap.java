//import java.util.Queue;

class BinaryHeap {
	private int[] heapArray;
	private int w = 100;
	private int n = 1;
	
	BinaryHeap() {
		heapArray = new int[w];
		heapArray[0] = -9999;
	}
	
	BinaryHeap(int w) {
		this.w = w;
		heapArray = new int[w];
		heapArray[0] = -9999;
	}
	
	BinaryHeap(int[] heapArray) {
		this.heapArray = heapArray;
		n += (heapArray.length - 1);
	}
	
	void setN(int n) {
		this.n = n;
	}
	
	int getN() {
		return this.n;
	}
	
	void swap(int x, int y) {
//		System.out.println("in swap");
//		System.out.println("heapArray[x] = " + heapArray[x] + "\theapArray[y] = " + heapArray[y]);
		heapArray[x] = (heapArray[x] + heapArray[y]) - (heapArray[y] = heapArray[x]);
//		System.out.println("heapArray[x] = " + heapArray[x] + "\theapArray[y] = " + heapArray[y]);
	}
	
	
	void insert(int e) {
		assert n<w: "Crossed the limits of the Heap Array";
		heapArray[n] = e;
//		System.out.println(this);
		shiftUp(n++);
//		System.out.println(this);
	}
	
	void shiftUp(int i) {
//		System.out.println(i);
		if (i == 1 || heapArray[i/2] <= heapArray[i]) {
//			System.out.println("in if i = " + i);
			return;
		}
		else {
			swap(i, i/2);
			shiftUp(i/2);
		}
	}
	
	int deleteMin() {
		assert n > 0;
		int result = heapArray[1];
		heapArray[1] = heapArray[n-1];
		heapArray[n-1] = 0;
		--n;
		shiftDown(1);
		return result;
	}
	
	void shiftDown(int i) {
//		System.out.println(n);
		int m = 0;
		if( (2 * i) <= n -1) {
			if( (2 * i) + 1 > n-1 || (heapArray[ 2 * i ] < heapArray[ (2 * i) +1])) m = 2 * i;
			else m = (2 * i) + 1;
			
			if(heapArray[i] > heapArray[m]) {
//				System.out.println(heapArray[i] +"\t" + heapArray[m]);
//				System.out.println("i = " + i + "\tm = " + m);
				swap(i, m);
//				System.out.println(heapArray[i] + "\t" + heapArray[m]);
				shiftDown(m);
			}
		}
//		System.out.println(this);
	}
	
	void modify(int index, int value) {
		heapArray[index] = value;
		modifyShift(index);
	}
	
	private void modifyShift(int i) {
		
		if(i > 1) {
			if(heapArray[i/2] > heapArray[i]) {
				shiftUp(i);
			}
			else shiftDown(i);
		}
		else if(i == 1) {
			shiftDown(i);
		}
		else if(i<0) {
			return;
		}
	}
	
	void binaryHeapRec(int i) {
//		System.out.println(i);
//		System.out.println(n);
		if(4 * i < n) {
			binaryHeapRec(2 * i);
			binaryHeapRec((2 * i) + 1);
		}
		shiftDown(i);
	}
	
	StringBuilder sb = new StringBuilder();
	String s = "";
	void subTree(int i) {
//		System.out.println(n);
		System.out.print(heapArray[i] + " ");
		s = s + i + " ";
		indexOrigin(i);
	}

	private void indexOrigin(int i) {
		
		if(2 * i < n) {
			s = s + (2*i);
			s = s + " ";
			System.out.print(heapArray[2 * i] + " ");
		}
		if((2*i) + 1 < n){
			sb.append((2*i) + 1);
			sb.append(" ");
			s = s + ((2*i) + 1);
			s = s + " ";
			System.out.print(heapArray[(2*i) + 1] + " ");
		}
		s = s.substring(s.indexOf(' ', 0) + 1);
		if(s.length() != 0) {
//			System.out.println("s = " + s + "\t" + s.length());
			indexOrigin(Integer.parseInt(s.substring(0, s.indexOf(' ', 0))));
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if(n == 1) {
			return "";
		}
		else {
			for(int i = 1; i < n - 1; ++i) {
				sb.append(heapArray[i]);
				sb.append(" ");
			}
			sb.append(heapArray[n - 1]);
			return sb.toString();
		}
	}
	String getStringS() {
		return s;
	}
}
