package io.confluent.kafka.schemaregistry.client.rest.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SchemaRegistryVersion {

	private String version;
	private String commitId;

	@JsonCreator
	public SchemaRegistryVersion(@JsonProperty("version") String version,
															 @JsonProperty("commitId") String commitId) {
		this.version = version;
		this.commitId = commitId;
	}

	@JsonProperty("version")
	public String getVersion() {
		return version;
	}

	@JsonProperty("version")
	public void setVersion(String version) {
		this.version = version;
	}

	@JsonProperty("commitId")
	public String getCommitId() {
		return commitId;
	}

	@JsonProperty("commitId")
	public void setCommitId(String commitId) {
		this.commitId = commitId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		SchemaRegistryVersion srVersion = (SchemaRegistryVersion) o;
		return Objects.equals(version, srVersion.version)
						&& Objects.equals(commitId, srVersion.commitId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(version, commitId);
	}
}
