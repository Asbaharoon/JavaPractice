
public class Base64 {
	public static void main(String[] args) {
		String test = "Ma";
		byte[] test_ = test.getBytes();
		byte[] res = Encode(test_);
		String res_ = new String(res);
		System.out.print(res_);

	}
	final static int GroupSize = 3;
	final static int resGroupSize = 4;
	
	public static byte[] Encode(byte[] text) {
		int storagesize = ((text.length + 2) / GroupSize) * resGroupSize;
		byte[] storage = new byte[storagesize];
		ProcessGroup(text, storage);
		ProcessPadding(text, storage);
		return storage;
	}

	public static int Base64Index(byte b0, byte b1, byte b2, boolean IsInGroup ) {
		
		byte i0 = (byte) (b0 >> 2);
		byte i1 = (byte) (((b0 << 4) & 0b00111111) | (b1 >> 4));
		byte i2 = (byte) (((b1 << 2) & 0b00111100) | (b2 >> 6));
		byte i3 = (byte) (b2 & 0b00111111);
		if(!IsInGroup) {
			final int PaddingCharIndex = 64; 
			if (0 == b1) {
				i2 = PaddingCharIndex;
				i3 = PaddingCharIndex;
			} else if (0 == b2) {
				i3 = PaddingCharIndex;
			}
		}
		int res = ((i0 << 24) | (i1 << 16) | (i2 << 8) | (i3));
		return res;
	}

	public static byte[] ProcessGroup(int GroupIndex, byte first, byte second, 
				byte third, byte[] res, boolean IsInGroup) {
		int index = Base64Index(first, second, third, IsInGroup);

		byte b0 = (byte) (index >> 24);
		byte b1 = (byte) ((index >> 16) & 0xff);
		byte b2 = (byte) ((index >> 8) & 0xff);
		byte b3 = (byte) (index & 0xff);
		byte b0_ = (byte) (Convert(b0));
		byte b1_ = (byte) (Convert(b1));
		byte b2_ = (byte) (Convert(b2));
		byte b3_ = (byte) (Convert(b3));
		
		int i__ = GroupIndex * resGroupSize;
		res[i__] = b0_;
		res[i__ + 1] = b1_;
		res[i__ + 2] = b2_;
		res[i__ + 3] = b3_;
		return res;
	}

	public static byte[] ProcessGroup(byte[] ori, byte[] res) {
		int oLength = ori.length;
		int NumberOfGroups = oLength / GroupSize;
		for (int i = 0; i < NumberOfGroups; i++) {
			int i_ = i * GroupSize;
			ProcessGroup(i, ori[i_], ori[i_ + 1], ori[i_ + 2], res, true);
		}
		return res;
	}

	public static char Convert(byte index) {
		final String cTable = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=";
		return cTable.charAt(index);
	}

	public static byte[] ProcessPadding(byte[] ori, byte[] res) {

		int oLength = ori.length;
		int GroupIndex = oLength / GroupSize;
		int PadRemainder = oLength % GroupSize;
		switch (PadRemainder) {
		case 0:
			return res;

		case 1: {
			byte b0 = ori[GroupIndex * GroupSize];
			return ProcessGroup(GroupIndex, b0, (byte) 0, (byte) 0, res, false);
		}

		case 2: {
			byte b0 = ori[GroupIndex * GroupSize];
			byte b1 = ori[(GroupIndex * GroupSize) + 1];
			return ProcessGroup(GroupIndex, b0, b1, (byte) 0, res, false);
			}
		}
		return res;
	}
}