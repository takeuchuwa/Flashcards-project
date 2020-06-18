public class AsciiCharSequence implements java.lang.CharSequence {

    private final byte[] value;

    public AsciiCharSequence(byte[] value) {
        this.value = value;
    }

    @Override
    public int length() {
        return value.length;
    }

    @Override
    public char charAt(int i) {
        return (char) value[i];
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        return new AsciiCharSequence(java.util.Arrays.copyOfRange(value, i, i1));
    }

    @Override
    public String toString() {
        return new String(this.value);
    }
}
