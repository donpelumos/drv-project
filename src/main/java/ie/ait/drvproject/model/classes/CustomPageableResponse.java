package ie.ait.drvproject.model.classes;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by Pelumi.Oyefeso on 13-04-2020
 */
@Getter
@Setter
@ApiModel(description = "Custom pageable response class that extracts information from the pageable and add custom information about the search.")
public class CustomPageableResponse<T, U> {
    @ApiModelProperty(notes = "The sort from the pageable.")
    private String sort;
    @ApiModelProperty(notes = "Total number of elements across all pages.")
    private int totalNumberOfElements;
    @ApiModelProperty(notes = "Size of the maximum number of elements per page.")
    private int requestedCurrentPageSize;
    @ApiModelProperty(notes = "Actual number of elements in the current paage.")
    private int actualCurrentPageSize;
    @ApiModelProperty(notes = "Current page number")
    private int currentPage;
    @ApiModelProperty(notes = "List of content in current page.")
    private List<U> content;
    @ApiModelProperty(notes = "Boolean that returns true is current page is the first page or false if otherwise.")
    private boolean isFirstPage;
    @ApiModelProperty(notes = "Boolean that returns true is current page is the last page or false if otherwise.")
    private boolean isLastPage;
    @ApiModelProperty(notes = "Total number of pages available")
    private int totalNumberOfPages;

    public CustomPageableResponse(){

    }

    public  CustomPageableResponse(Page<T> items, List<U> itemsWellFormatted){
        this.sort = items.getPageable().getSort().toString().replace(":",",");
        this.totalNumberOfElements = (int)items.getTotalElements();
        this.content = itemsWellFormatted;
        this.requestedCurrentPageSize = items.getPageable().getPageSize();
        this.actualCurrentPageSize = items.getContent().size();
        this.currentPage = items.getPageable().getPageNumber();
        if(this.totalNumberOfElements < this.requestedCurrentPageSize){
            this.isFirstPage = true;
            this.isLastPage = true;
        }
        else if(((this.currentPage + 1) * requestedCurrentPageSize) >= this.totalNumberOfElements){
            this.isLastPage = true;
        }
        else if((this.actualCurrentPageSize + currentPage) <= this.requestedCurrentPageSize){
            this.isFirstPage = true;
        }
        else{
            this.isFirstPage = false;
            this.isLastPage = false;
        }
        this.totalNumberOfPages = (int)Math.ceil(((double)this.totalNumberOfElements)/((double)this.requestedCurrentPageSize));
    }
}
