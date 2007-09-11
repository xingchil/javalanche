package org.softevo.mutation.bytecodeMutations.replaceIntegerConstant;


import org.apache.log4j.Logger;
import org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.softevo.mutation.mutationPossibilities.MutationPossibilityCollector;

public class PossibilitiesRicClassAdapter extends ClassAdapter {

	private static Logger logger = Logger
			.getLogger(PossibilitiesRicClassAdapter.class);

	private PossibilitiesRicMethodAdapter actualAdapter;

	private String lastMethodName;

	private String className;

	private MutationPossibilityCollector mutationPossibilityCollector;

	public PossibilitiesRicClassAdapter(ClassVisitor cv, MutationPossibilityCollector collector) {
		super(cv);
		this.mutationPossibilityCollector =  collector;
	}

	@Override
	public void visit(int version, int access, String name, String signature,
			String superName, String[] interfaces) {
		className = name;
		super.visit(version, access, name, signature, superName, interfaces);
	}

	@Override
	public MethodVisitor visitMethod(int access, String name, String desc,
			String signature, String[] exceptions) {
		printResultOfLastMethod();
		lastMethodName = name;
		actualAdapter = new PossibilitiesRicMethodAdapter(super.visitMethod(
				access, name, desc, signature, exceptions),className, name,mutationPossibilityCollector);
		return actualAdapter;

	}

	private void printResultOfLastMethod() {
		if (actualAdapter != null) {
			logger.info(String.format(
					"%d possibilitities found for method: %s in %s ", actualAdapter
							.getPossibilities(), lastMethodName,className));
			actualAdapter = null;
		}
	}

	@Override
	public void visitEnd() {
		printResultOfLastMethod();
		super.visitEnd();
	}

}
