package water;
    
    public class waterTile {
         
        public static final float TILE_SIZE = 60;
         
        private float height;
        private float x,z;
         
        public waterTile(float centerX, float centerZ, float height){
            this.x = centerX;
            this.z = centerZ;
            this.height = height;
        }
     
        public float getHeight() {
            return height;
        }
     
        public float getX() {
            return x;
        }
     
        public float getZ() {
            return z;
        }
    }