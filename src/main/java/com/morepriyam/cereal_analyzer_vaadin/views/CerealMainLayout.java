package com.morepriyam.cereal_analyzer_vaadin.views;

import com.morepriyam.cereal_analyzer_vaadin.security.SecurityService;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.LumoUtility;

import jakarta.annotation.security.PermitAll;

@PermitAll
@Route("")
public class CerealMainLayout extends AppLayout {

	private static final long serialVersionUID = 1L;

	private final SecurityService securityService;

	public CerealMainLayout(SecurityService securityService) {
		this.securityService = securityService;
		createHeader();
		createDrawer();
	}

	private void createHeader() {
		H1 logo = new H1("Cereal Analyzer");
		logo.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.MEDIUM);

		String username = securityService.getAuthenticatedUser().getUsername();
		Button logout = new Button("Log out (" + username + ")", e -> securityService.logout());

		HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo, logout);
		header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
		header.expand(logo);
		header.setWidthFull();
		header.addClassNames(LumoUtility.Padding.Vertical.NONE, LumoUtility.Padding.Horizontal.MEDIUM);

		addToNavbar(header);
	}

	private void createDrawer() {
		RouterLink cerealsLink = new RouterLink("Cereals", CerealView.class);
		cerealsLink.setHighlightCondition(HighlightConditions.sameLocation());

		RouterLink manufacturersLink = new RouterLink("Manufacturers", ManufacturerView.class);

		VerticalLayout drawerLayout = new VerticalLayout(cerealsLink, manufacturersLink);
		drawerLayout.addClassNames(LumoUtility.Padding.MEDIUM);

		addToDrawer(drawerLayout);
	}
}
