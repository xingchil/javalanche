package de.unisb.cs.st.javalanche.coverage;

import org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;

/**
 * @author Bernhard Gruen
 * 
 */
 
public class CoverageClassAdapter extends ClassAdapter {

	private String className;
	private int classAccess;

	public CoverageClassAdapter(ClassVisitor visitor, String theClass) {
		super(visitor);
		this.className = theClass;
	}

	public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
		super.visit(version, access, name, signature, superName, interfaces);
		this.classAccess = access;
	}

	/*
	 * (non-Javadoc)
	 * @see org.objectweb.asm.ClassAdapter#visitMethod(int, java.lang.String, java.lang.String, java.lang.String, java.lang.String[])
	 */
	public MethodVisitor visitMethod(int methodAccess, String name, String descriptor, String signature, String[] exceptions) {
		MethodVisitor mv = super.visitMethod(methodAccess, name,	descriptor,	signature, exceptions);
		// TODO
		if(!className.endsWith("org/apache/commons/lang/builder/ReflectionToStringBuilder") &&!className.endsWith("org/apache/commons/lang/builder/ToStringBuilder")){
			mv = new CoverageMethodAdapter(mv, className, name, descriptor, classAccess, methodAccess);
		}
		return mv;
	}

}