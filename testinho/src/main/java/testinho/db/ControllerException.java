package testinho.db;

import java.io.Serial;

public class ControllerException extends RuntimeException{
	@Serial
	private static final long serialVersionUID = 1L;

	public ControllerException(String msg) {
		super(msg);
	}
}
