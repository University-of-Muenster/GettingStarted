package org.processmining.plugins.export2em.converters;

import org.processmining.plugins.export2em.emDataTypes.Model;

public abstract class AbstractConverter {
	public static Model convert(Object source){
        throw new IllegalStateException(
                "Convert method hasn't been set up in the subclass");
	};
}
