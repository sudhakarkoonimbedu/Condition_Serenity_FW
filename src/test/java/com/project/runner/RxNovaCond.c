#include <stdio.h>
#include <stdlib.h>

#include <jni.h>

main(int argc, char ** argv)
{
        JavaVM * jvm;
        JNIEnv * env;
        env = create_vm(&jvm);
        if(env == NULL)
        {
                return EXIT_FAILURE;
        }
        // invoke_class(env);
        return EXIT_SUCCESS;
}

JNIEnv * createVM(JavaVM ** jvm)
{
	JNIEnv * env;
    	JavaVMInitArgs args;
    	JavaVMOption options;
    	args.version = JNI_VERSION_1_8;
    	args.nOptions = 1;
	options.optionString = "-Djava.class.path=./";
   	args.options = &options;
    	args.ignoreUnrecognized = 0;
    	int rv;
    	rv = JNI_CreateJavaVM(jvm, (void**)&env, &args);
    	if (rv < 0 || !env) {
        	printf("Unable to Launch JVM %d\n",rv);
    	}
    	else {
        	printf("Launched JVM! :)\n");
    	}
   
    	return env;
}









