package StackTree;

public class Node {

	int point;
	int value;
	int nextPoint;
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getNextPoint() {
		return nextPoint;
	}
	public void setNextPoint(int nextPoint) {
		this.nextPoint = nextPoint;
	}
	@Override
	public String toString() {
		return "Node [point=" + point + ", value=" + value + ", nextPoint=" + nextPoint + "]";
	}
	
}
