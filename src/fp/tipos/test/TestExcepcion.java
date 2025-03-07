package fp.tipos.test;

public class TestExcepcion {

	public static void main(String[] args) {
		try {
			System.out.println("Antes de la excepción");
			//throw new IllegalStateException();
			Integer i = 2 / 0;
			System.out.println("No hay excepción");
		} catch (IllegalStateException e) {
			System.out.println("Se ha lanzando una excepción IllegalStateException");
		}catch (Exception e) {
			System.out.println("No he identificado la excepción");
		}
		finally {
			System.out.println("Después de la excepción");
		}
	}

}
