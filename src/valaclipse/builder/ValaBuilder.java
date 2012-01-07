/*******************************************************************************
 * Copyright (c) 2012 Taylor Raack <traack@raack.info>.
 * 
 * This file is part of Valaclipse.
 * 
 * Valaclipse is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 * 
 * Valaclipse is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with Valaclipse.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * Additional permission under GNU GPL version 3 section 7
 * 
 * If you modify this Program, or any covered work, by linking or combining it with Eclipse (or a modified version of that library), containing parts covered by the terms of the Eclipse Public License, the licensors of this Program grant you additional permission to convey the resulting work. Corresponding Source for a non-source form of such a combination shall include the source code for the parts of Eclipse used as well as that of the covered work.
 ******************************************************************************/
package valaclipse.builder;

import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

public class ValaBuilder extends IncrementalProjectBuilder {

	public static final String BUILDER_ID = "valaclipse.builder";
	
	protected IProject[] build(int kind, Map args, IProgressMonitor monitor) throws CoreException {

		// only do full builds for the moment. will later be enhanced to do incremental builds with Vala fast-vapi features
		fullBuild(monitor);
		
		return null;
	}

	protected void fullBuild(final IProgressMonitor monitor) throws CoreException {
		try {
			monitor.beginTask("Launching Vala Project Build", IProgressMonitor.UNKNOWN);
			
			ValaBuildJob job = new ValaBuildJob(getProject());
			job.schedule();
			
			monitor.done();
			
		} catch (CoreException e) {
			// TODO - handle exception properly
		}
	}
}
