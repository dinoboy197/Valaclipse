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

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

import valaclipse.Valaclipse;
import valaclipse.model.ValaProject;

public class ValaBuildJob extends Job {
	
	private ValaProject project;
	
	public ValaBuildJob(IProject iproject) throws CoreException {
		super("Building Vala Project...");
		
		// actual instantiation of vala project object is here
		project = new ValaProject(iproject);
	}
	
	@Override
	protected IStatus run(IProgressMonitor monitor) {
		// building is a function of the project itself
		try {
			return project.build(monitor);
		} catch (CoreException e) {
			return new Status(IStatus.ERROR, Valaclipse.PLUGIN_ID, 1, "Error while building project", e);
		}
	}
}
