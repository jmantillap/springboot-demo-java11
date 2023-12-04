package work.javiermantilla.proyecto.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DataListDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("data")
    private transient List<DataItem> data;

    
	@Data
	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	public static class DataItem {
	    private int x;
	    private int y;
	    private int n;
	    private int output;
	}    
	
}
