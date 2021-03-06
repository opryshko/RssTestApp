
package com.geekapps.rsstestapp.data.network.pojo.detail_information;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DetailInformation {

    @SerializedName("resultCount")
    @Expose
    private Integer resultCount;
    @SerializedName("results")
    @Expose
    private List<DetailInformationItem> results = null;

    public Integer getResultCount() {
        return resultCount;
    }

    public void setResultCount(Integer resultCount) {
        this.resultCount = resultCount;
    }

    public List<DetailInformationItem> getResults() {
        return results;
    }

    public void setResults(List<DetailInformationItem> results) {
        this.results = results;
    }

}
