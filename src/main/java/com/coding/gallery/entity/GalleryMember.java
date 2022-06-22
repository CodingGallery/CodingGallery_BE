package com.coding.gallery.entity;

import lombok.*;
import lombok.Builder;
import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
//@Table(name = "user")
public class GalleryMember extends BaseEntity {
	
	@Id
	private String email;
	private String password;
	private String name;
	private String image;
	
	@Enumerated(EnumType.STRING)
	private GalleryMemberRole role;

	//@ElementCollection(fetch = FetchType.LAZY)
	//@Builder.Default
	//private Set<GalleryMemberRole> roleSet = new HashSet<>();
	
	//public void addGalleryMemberRole(GalleryMemberRole galleryMemberRole) {
		//roleSet.add(galleryMemberRole);ps
	//}
	 
}
