package models;

public class rawModel {

	private int vaoID;
	private int vertexCount;
	
		public rawModel (int vaoID, int vertexCount){
				 this.vaoID = vaoID;
				 this.vertexCount = vertexCount;
		}

		public int getVaoID() {
			return vaoID;
		}

		public int getVertexCount() {
			return vertexCount;
		}
}
