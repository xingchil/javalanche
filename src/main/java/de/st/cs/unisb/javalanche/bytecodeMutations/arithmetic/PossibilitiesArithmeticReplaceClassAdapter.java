package de.st.cs.unisb.javalanche.bytecodeMutations.arithmetic;

import java.util.HashMap;
import java.util.Map;

import org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import de.st.cs.unisb.javalanche.mutationPossibilities.MutationPossibilityCollector;

public class PossibilitiesArithmeticReplaceClassAdapter extends ClassAdapter {
	private String className;

	private final MutationPossibilityCollector mutationPossibilityCollector;

	private Map<Integer, Integer> possibilities = new HashMap<Integer, Integer>();

	public PossibilitiesArithmeticReplaceClassAdapter(ClassVisitor cv,
			MutationPossibilityCollector mutationPossibilityCollector) {
		super(cv);
		this.mutationPossibilityCollector = mutationPossibilityCollector;
	}

	@Override
	public void visit(int version, int access, String name, String signature,
			String superName, String[] interfaces) {
		super.visit(version, access, name, signature, superName, interfaces);
		className = name;
	}

	@Override
	public MethodVisitor visitMethod(int access, String name, String desc,
			String signature, String[] exceptions) {
		return new PossibilitiesArithmeticReplaceMethodAdapter(super
				.visitMethod(access, name, desc, signature, exceptions),
				className, name, mutationPossibilityCollector, possibilities);
	}
}
