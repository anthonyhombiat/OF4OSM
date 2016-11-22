package lig.steamer.of4osm.core.onto.meta;

import java.util.Set;

import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagStatefulKey;


public interface IOSMTagStatefulKeyConcept extends IOSMTagKeyConcept {
	
	@Override
	public IOSMTagStatefulKey getKey();

	@Override
	public Set<IOSMTagStatefulKeyConceptParent> getParents();
	
	/**
	 * 
	 * @param parent
	 */
	public void addParent(IOSMTagStatefulKeyConceptParent parent);

}
