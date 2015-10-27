package org.processmining.plugins.export2em;

import java.io.InputStream;

import org.processmining.contexts.uitopia.annotations.UIImportPlugin;
import org.processmining.framework.abstractplugins.AbstractImportPlugin;
import org.processmining.framework.plugin.PluginContext;
import org.processmining.framework.plugin.annotations.Plugin;
 
@Plugin(name = "Import Text",
        parameterLabels = { "Filename" },
        returnLabels = { "String" },
        returnTypes = { String.class })
@UIImportPlugin(description = "String",
                extensions = { "txt" })
public class ImportPlugin extends AbstractImportPlugin {
  @Override
  protected String importFromStream(final PluginContext context,
                                    final InputStream input,
                                    final String filename,
                                    final long fileSizeInBytes) {
    try {
      context.getFutureResult(0).setLabel("String imported from " + filename);
    } catch (final Throwable _) {
      // Don't care if this fails
    }
    String result = "Test";
    // Fill in object from input
    return result;
  }
}

