package lucee.transformer.dynamic.meta;

public class MethodDynamic extends FunctionMemberDynamic implements Method {

	private static final long serialVersionUID = 7046827988301434206L;

	public MethodDynamic(Class declaringClass, String name) {
		super(name);
	}
}