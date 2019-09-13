package com.isd.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class locatorClass {
	
	WebDriver driver;
	
	public locatorClass(WebDriver driver) {
		this.driver = driver;
		
	}

	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	        //      ------------ TAB CLICKS -------------------------
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	By tab_ExecSummary = By.xpath("//*[@id='exe']");
	By tab_AggPipe = By.xpath("//*[@id='agg']");
	By tab_SegPipe = By.xpath("//*[@id='seg']");
	By tab_Roadmap = By.xpath("//*[@id='roadmap']");
	By tab_KeyDeals = By.xpath("//*[@id='keydeals']");
	By tab_milestone = By.xpath("//*[@id='milestone']");
	
	
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //      ------------ TOP NAV -------------------------
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	
	By topNav_ExpColl = By.xpath("//*[@style='cursor:pointer']");
	By topNav_View_ArrowWrapper = By.xpath("//carbon-dropdown[@id='bread_GROUP']//span[@class='ng-arrow-wrapper']");
	
	
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //      ------------ KPI -------------------------
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	By block_WSR_KPI = By.cssSelector("div .showPointer:nth-of-type(6)");
	By kpi_LiVal = By.xpath("//p[@class='headertext']");
	By kpi_Deals = By.cssSelector("div.datatable-group-header div.col-md-2");
	By kpi_LiCol = By.cssSelector("#skylineDealListTable .datatable-row-wrapper div.col-md-2:nth-of-type(2)");
	By kpi_ShowAllDeals = By.xpath("//a[text()='Show All Deals...']");
	By allDeals_LiCol = By.cssSelector("#skylineTransactionalKeydealsTable .datatable-row-wrapper div .col-md-3:nth-of-type(2)");
	By kpiStrip = By.xpath("//*[@class='row skyline-breadcrumb relative']");
	By kpi_Name_Budget = By.xpath("//*[text()='BUDGET ']");
	By kpi_Value_Budget = By.xpath("//*[text()='BUDGET ']/../div[@class='value']");
	By kpi_Name_WSR = By.xpath("//*[text()='WSR'][1]");
	By kpi_Value_WSR = By.xpath("//*[text()='WSR']/../div[@class='value']");
	By kpi_Name_VP = By.xpath("(//*[text()='VP'])[1]");
	By kpi_Value_VP = By.xpath("//*[text()='VP']/../div[@class='value']");
	By kpi_Name_WON = By.xpath("//*[text()='WON'][1]");
	By kpi_Value_WON = By.xpath("//*[text()='WON']/../div[@class='value']");
	By kpi_Name_QP = By.xpath("//*[text()='QP'][1]");
	By kpi_Value_QP = By.xpath("//*[text()='QP']/../div[@class='value']");
	By kpi_Name_SolAR = By.xpath("//*[text()='SOLID+AT RISK'][1]");
	By kpi_Value_SolAR = By.xpath("//*[text()='SOLID+AT RISK']/../div[@class='value']");
	By kpi_Name_WsrKS = By.xpath("//*[text()='WSR+KEY STRETCH'][1]");
	By kpi_Value_WsrKS = By.xpath("//*[text()='WSR+KEY STRETCH']/../div[@class='value']");
	
	By VPKPI = By.xpath("(//*[@class='verticalCenter'])[5]");
	By WSRKPI = By.xpath("(//*[@class='verticalCenter'])[6]");
	By WONKPI = By.xpath("(//*[@class='verticalCenter'])[7]");
	By QPKPI = By.xpath("(//*[@class='verticalCenter'])[6]");
	
	
	// --------------------- DEAL LIST (KPI) -------------------------------------------
	
	By kpi_to_DealList = By.xpath("//datatable-body[@class='datatable-body']");
	By kpi_DL_Header = By.xpath("(//p[@class='headertext'])[1]");
	By kpi_DL_LiCol = By.cssSelector("#skylineDealListModal .datatable-row-wrapper div.col-md-2:nth-of-type(2)");
	By kpi_DL_CloseIcon = By.xpath("//*[@class='bx--modal-close__icon ng-star-inserted']//*[@fill-rule='nonzero']"); 
	By kpi_DL_CloseIcon1 = By.xpath("(//*[@class='bx--modal-close__icon ng-star-inserted']//*[@fill-rule='nonzero'])[2]"); 
	
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
             //      ------------ EXPAND/COLLAPSE - GRAPH AND TABLE -------------------------
   //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	
	By es_graph_load = By.xpath("//carbon-icon[@name='icon--maximize']/ancestor::div[@class='row']");
	By ap_graph_TopLoad = By.xpath("//div[@id='aggCharts']");
	By ap_graph_BottomLoad = By.xpath("(//carbon-icon[@name='icon--maximize']/ancestor::div[@class='row'])[2]");
	By sp_graph_load = By.xpath("//div[@class='row charts-container']");
	By rm_graph_TopLoad = By.xpath("//*[name()='carbon-skyline-roadmap-budget']/ancestor::div[@class='row ng-star-inserted']");
	By rm_graph_BottomLoad = By.xpath("//h4[text()='ROADMAP TRACK']/ancestor::div[@class='row ng-star-inserted']");
	By graph_ExpandIcon = By.xpath("//carbon-icon[@name='icon--maximize']/*[@class='ng-star-inserted']");
//	By tbl_ShowHide = By.xpath("//button[@class='buttonShowHide']");
	By tbl_ShowTbl = By.xpath("//button[text()='Show Table ']");
	By tbl_HideTbl = By.xpath("//button[text()='Hide Table ']");
	By tbl_ShowCaret = By.xpath("//div[@style = 'transform: rotate(0deg);']");
	By tbl_HideCaret = By.xpath("//div[@style = 'transform: rotate(180deg);']");
	By tbl_FirstRow = By.xpath("//div[@class='datatable-body-cell-label']/span[@class='ng-star-inserted']");
	
	By graph_RestoreIcon = By.xpath("//carbon-icon[@name='icon--minimize']/*[@class='ng-star-inserted']");
	
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
           //      ------------ KEY DEALS -------------------------
   //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	By kd_View_Label = By.xpath("//*[text()='GROUP : ']"); 
	By kd_View_DropDown = By.xpath("//carbon-dropdown[@id='bread_GROUP']");
	By kd_View_Options = By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div[@role='option']");
	public String kd_View_Options_Path = "//div[@class='ng-dropdown-panel-items scroll-host']//div[@role='option']";
	By kd_Li_Header_Value = By.xpath("(//p[@class='headertext'])[2]");
	By kd_Gear_NewView_ChkBox = By.xpath("//input[@class='bx--checkbox']");
	By kd_Gear_NewView_ChkLabel = By.xpath("//div[@class='col-md-6 col-sm-6 col-xs-6 deallistLabel ng-star-inserted']//label");
	By kd_Gear_NewView_TitleTxt = By.xpath("//h2[@class='custom-heading']");
	By kd_Gear_NewView_FilterIcon = By.cssSelector("img[src='assets/images/Filter.svg']");
	By kd_Gear_NewView_Filter_DropDown = By.xpath("//carbon-dropdown[@id='dealList']");
	By kd_Twisty_PlusIcon = By.xpath("//*[@class='plusIcon plusandminusicon']");
	By kd_Twisty_MinusIcon = By.xpath("//*[@class='minusIcon plusandminusicon']");
	By kd_FirstRow = By.cssSelector("datatable-body-row.datatable-body-row:nth-of-type(1)");
	By kd_First_LiVal = By.xpath("(//*[@class='col-md-3']/p)[1]");
	By kd_FirstTwisty_ExColl = By.xpath("(//div[@class='col-md-4']/p)[1]//a[@title='Expand/Collapse']");
	By kd_Table_Value_Col = By.cssSelector(".datatable-body-row .datatable-body-cell:nth-of-type(2)");
	By kd_Pagination = By.xpath("(//div[@class='skp-select'])[1]");
	By kd_Pagination_Loop = By.xpath("//div[@role='option']");
	By kd_Oppty_Col = By.cssSelector("#skylineTransactionalKeydealsTable .datatable-row-wrapper div .col-md-3:nth-of-type(3)");
	By kd_Pages_List = By.xpath("(//div[@class='ng-value-container']//child::input)[8]");

	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
               //      ------------ ROADMAP -------------------------
   //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
//	By rm_RM2BudgetBars = By.xpath("//div[@id='roadmapBudgetContainer']//*[name()='g'][@class='bar-container']//*[name()='text']");
	By rm_RM2BudgetBarsv2 = By.xpath("//div[@id='roadmapBudgetContainer']//*[name()='g'][@class='group-container']/*[name()='text']");
	By rm_Won_Bar = By.xpath("//div[@id='roadmapBudgetContainer']//*[name()='g'][@class='bar-container']//*[name()='text']");
	By rm_Solid_Bar = By.xpath("(//div[@id='roadmapBudgetContainer']//*[name()='g'][@class='group-container']/*[name()='text'])[3]");
	By rm_AtRisk_Bar = By.xpath("(//div[@id='roadmapBudgetContainer']//*[name()='g'][@class='group-container']/*[name()='text'])[4]");
	By rm_KS_Bar = By.xpath("(//div[@id='roadmapBudgetContainer']//*[name()='g'][@class='group-container']/*[name()='text'])[5]");
	
	
	
	// --------------------- SAQ RELATED -------------------------------
	By saq_graphTitle = By.xpath("//h4[text()='SALES ACTION QUADRANTS']");
	By saq_graphMaximize = By.xpath("//h4[text()='SALES ACTION QUADRANTS']//..//carbon-icon[@name='icon--maximize']");
	By saq_ProbeTxt = By.xpath("//h4[text()='SALES ACTION QUADRANTS']//..//div[text()='PROBE']//..//*[@class='tooltiptext']");
	By saq_tbl_ProbeData = By.cssSelector("datatable-body.datatable-body datatable-row-wrapper:nth-of-type(2)");
	By saq_Close = By.xpath("//div[text()='CLOSE']");
	By saq_CloseTxt = By.xpath("//h4[text()='SALES ACTION QUADRANTS']//..//div[text()='CLOSE']//..//*[@class='tooltiptext']");
	By saq_tbl_CloseData = By.cssSelector("datatable-body.datatable-body datatable-row-wrapper:nth-of-type(1)");
	By saq_RefineTxt = By.xpath("//h4[text()='SALES ACTION QUADRANTS']//..//div[text()='REFINE']//..//*[@class='tooltiptext']");
	By saq_tbl_RefineTxt = By.cssSelector("datatable-body.datatable-body datatable-row-wrapper:nth-of-type(4)");
	By saq_AdvanceTxt = By.xpath("//h4[text()='SALES ACTION QUADRANTS']//..//div[text()='ADVANCE']//..//*[@class='tooltiptext']");
	By saq_tbl_AdvanceData = By.cssSelector("datatable-body.datatable-body datatable-row-wrapper:nth-of-type(3)");
	
	
	// --------------------- OTHERS -------------------------------
	
	By click_Somewhere_Outside = By.xpath("//div[@class='col-md-6 col-sm-6 col-xs-6']");
	By gearIcon = By.cssSelector("carbon-overflow-menu[icon-name='settings']");
	By gear_NewFilterView = By.xpath("//div[text()=' NEW FILTERS/VIEWS ']");
	By cancel_Icon = By.xpath("(//*[@class='bx--modal-close__icon ng-star-inserted']//*[@fill-rule='nonzero'])[2]");
}
