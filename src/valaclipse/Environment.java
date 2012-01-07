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
package valaclipse;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Environment {
	
	public List<String> getTypicalPackageDirectories() {
		List<String> packageDirectories = new ArrayList<String>();
		
		if(System.getProperty("os.name").equals("Linux")) {
			if(new File("/usr/share/vala/vapi").exists()) {
				packageDirectories.add("/usr/share/vala/vapi");
			}
			if(new File("/usr/local/share/vala/vapi").exists()) {
				packageDirectories.add("/usr/local/share/vala/vapi");
			}
		} 
		
		// TODO - add the default directories for mac and windows if detected
		
		return packageDirectories;
	}
}
