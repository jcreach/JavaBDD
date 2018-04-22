/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package com.julienCreach.agenceVoyage.GUI;

import com.julienCreach.agenceVoyage.GUI.Popup.*;
import com.julienCreach.agenceVoyage.Table.*;
import com.julienCreach.agenceVoyage.managers.TableManager;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.LoadException;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class adminWindowController
{
    //region Private Attributs

    /**
     * selection model du TabPane.
     */
    private SingleSelectionModel<Tab> selectionModel;

    /**
     * TabPane principal.
     */
    @FXML
    private TabPane tabPaneMain;

    /**
     * Datagrid circuits.
     */
    @FXML
    private TableView<Circuit> tableViewCircuits;

    /**
     * Datagrid Clients.
     */
    @FXML
    private TableView<Client> tableViewClients;

    /**
     * Datagrid Hotels.
     */
    @FXML
    private TableView<Hotel> tableViewHotels;

    /**
     * Datagrid Villes.
     */
    @FXML
    private TableView<Ville> tableViewVilles;

    /**
     * Datagrid Accompagnateurs.
     */
    @FXML
    private TableView<Accompagnateur> tableViewAccompagnateurs;

    /**
     * Datagrid Reservations.
     */
    @FXML
    private TableView<Reservation> tableViewReservations;

    @FXML
    private TextField textFieldRequete;
    /**
     * Boutton exit de la barre de menu.
     */
    @FXML
    private MenuItem menuItemQuit;

    //endregion Private Attributs

    //region Public Attributs

    //endregion Public Attributs

    //region Constructors / Initialisation

    /**
     * Constructeur par defaut
     */
    public adminWindowController()
    {
    }

    //endregion Constructors / Initialisation

    //region Private Services

    //region FXML

    /**
     * Actions au click sur le menuitem quit.
     */
    @FXML
    private void menuItemQuitClick()
    {
        System.exit(0);
    }

    @FXML
    private void menuItemStatisticsClick()
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("statisticWindow.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Statistiques");
            stage.setScene(new Scene(root));
            stage.showAndWait();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Actions sur bouton de suppression
     */
    @FXML
    private void butSuprClick()
    {
        switch (selectionModel.getSelectedIndex())
        {
            case 0:
                System.out.println(" => Supression Circuit ...");
                Circuit newCircuit = tableViewCircuits.getSelectionModel().getSelectedItem();
                if(newCircuit != null)
                {
                    TableManager.Instance().get_circuitDAO().Delete(newCircuit);
                }
                break;

            case 1 :
                System.out.println(" => Supression Client ...");
                Client newClient = tableViewClients.getSelectionModel().getSelectedItem();
                if(newClient != null)
                {

                    TableManager.Instance().get_clientDAO().Delete(newClient);
                }
                break;
            case 2 :
                System.out.println(" => Supression Hotel ...");
                Hotel newHotel = tableViewHotels.getSelectionModel().getSelectedItem();
                if(newHotel != null)
                {
                    TableManager.Instance().get_hotelDAO().Delete(newHotel);
                }
                break;
            case 3 :
                System.out.println(" => Supression Ville ...");
                Ville newVille = tableViewVilles.getSelectionModel().getSelectedItem();
                if(newVille != null)
                {
                    TableManager.Instance().get_villeDAO().Delete(newVille);
                }
                break;
            case 4 :
                System.out.println(" => Supression Accompagnateur ...");
                Accompagnateur newAccompagnateur = tableViewAccompagnateurs.getSelectionModel().getSelectedItem();
                if(newAccompagnateur != null)
                {
                    TableManager.Instance().get_accompagnateurDAO().Delete(newAccompagnateur);
                }
                break;
            case 5 :
                System.out.println(" => Supression Reservation ...");
                Reservation newReservation = tableViewReservations.getSelectionModel().getSelectedItem();
                if(newReservation != null)
                {
                    TableManager.Instance().get_reservationDAO().Delete(newReservation);
                }
                break;
        }
        this.LoadTables();
    }

    /**
     * Actions sur bouton d'ajout
     */
    @FXML
    private void butAjoutClick()
    {
        switch (selectionModel.getSelectedIndex())
        {
            case 0 :
                System.out.println(" => Tab Circuits ...");
                try
                {
                    ajoutCircuitController.setIsNewOrEdit(true);
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Popup/ajoutCircuit.fxml"));
                    Parent root = fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setResizable(false);
                    stage.setTitle("Ajout Circuit");
                    stage.setScene(new Scene(root));
                    stage.showAndWait();
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
                break;
            case 1 :
                System.out.println(" => Tab Clients ...");
                try
                {
                    ajoutClientController.setIsNewOrEdit(true);
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Popup/ajoutClient.fxml"));
                    Parent root = fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setResizable(false);
                    stage.setTitle("Ajout Client");
                    stage.setScene(new Scene(root));
                    stage.showAndWait();
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
                break;
            case 2 :
                System.out.println(" => Tab Hotels ...");
                try
                {
                    ajoutHotelController.setIsNewOrEdit(true);
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Popup/ajoutHotel.fxml"));
                    Parent root = fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setResizable(false);
                    stage.setTitle("Ajout Hotel");
                    stage.setScene(new Scene(root));
                    stage.showAndWait();
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
                break;
            case 3 :
                System.out.println(" => Tab Villes ...");
                try
                {
                    ajoutVilleController.setIsNewOrEdit(true);
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Popup/ajoutVille.fxml"));
                    Parent root = fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setResizable(false);
                    stage.setTitle("Ajout Ville");
                    stage.setScene(new Scene(root));
                    stage.showAndWait();
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
                break;
            case 4 :
                System.out.println(" => Tab Accompagnateurs ...");
                try
                {
                    ajoutAccompagnateurController.setIsNewOrEdit(true);
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Popup/ajoutAccompagnateur.fxml"));
                    Parent root = fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setResizable(false);
                    stage.setTitle("Ajout Accompagnateur");
                    stage.setScene(new Scene(root));
                    stage.showAndWait();
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
                break;
            case 5 :
                System.out.println(" => Tab Reservations ...");
                try
                {
                    ajoutReservationController.setIsNewOrEdit(true);
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Popup/ajoutReservation.fxml"));
                    Parent root = fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setResizable(false);
                    stage.setTitle("Ajout Reservation");
                    stage.setScene(new Scene(root));
                    stage.showAndWait();
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
        this.LoadTables();
    }

    /**
     * Actions sur bouton d'edition
     */
    @FXML
    private void butEditClick()
    {
        try
        {

            switch (selectionModel.getSelectedIndex())
            {
                case 0:
                    try
                    {
                        ajoutCircuitController.setIsNewOrEdit(false);
                        ajoutCircuitController.set_selectedCircuit(tableViewCircuits.getSelectionModel().getSelectedItem());

                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Popup/ajoutCircuit.fxml"));
                        Parent root = fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.setResizable(false);
                        stage.setTitle("Edit Circuit");
                        stage.setScene(new Scene(root));
                        stage.showAndWait();
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }

                    break;
                case 1 :
                    try
                    {
                        ajoutClientController.setIsNewOrEdit(false);
                        ajoutClientController.set_selectedClient(tableViewClients.getSelectionModel().getSelectedItem());
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Popup/ajoutClient.fxml"));
                        Parent root = fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.setResizable(false);
                        stage.setTitle("Edit Client");
                        stage.setScene(new Scene(root));
                        stage.showAndWait();
                    }
                            catch (LoadException e)
                    {
                        e.printStackTrace();
                    }
                    break;
                case 2 :
                    try
                    {
                        ajoutHotelController.setIsNewOrEdit(false);
                        ajoutHotelController.set_selectedHotel(tableViewHotels.getSelectionModel().getSelectedItem());
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Popup/ajoutHotel.fxml"));
                        Parent root = fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.setResizable(false);
                        stage.setTitle("Edit Hotel");
                        stage.setScene(new Scene(root));
                        stage.showAndWait();
                    }
                     catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                    break;
                case 3 :
                    try
                    {
                        ajoutVilleController.setIsNewOrEdit(false);
                        ajoutVilleController.set_selectedVille(tableViewVilles.getSelectionModel().getSelectedItem());
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Popup/ajoutVille.fxml"));
                        Parent root = fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.setResizable(false);
                        stage.setTitle("Edit Ville");
                        stage.setScene(new Scene(root));
                        stage.showAndWait();
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                    break;
                case 4 :
                    try
                    {
                        ajoutAccompagnateurController.setIsNewOrEdit(false);
                        ajoutAccompagnateurController.set_selectedAccompagnateur(tableViewAccompagnateurs.getSelectionModel().getSelectedItem());
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Popup/ajoutAccompagnateur.fxml"));
                        Parent root = fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.setResizable(false);
                        stage.setTitle("Edit Accompagnateur");
                        stage.setScene(new Scene(root));
                        stage.showAndWait();
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                    break;
                case 5 :
                    try
                    {
                        ajoutReservationController.setIsNewOrEdit(false);
                        ajoutReservationController.set_selectedReservation(tableViewReservations.getSelectionModel().getSelectedItem());
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Popup/ajoutReservation.fxml"));
                        Parent root = fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.setResizable(false);
                        stage.setTitle("Edit Reservation");
                        stage.setScene(new Scene(root));
                        stage.showAndWait();
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                    break;
                default:
                    break;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        this.LoadTables();
    }

    /**
     * Initialisation des datas dans la fentere.
     */
    @FXML
    private void initialize()
    {
        this.LoadTables();
    }

    /**
     * Actions au double click sur un élément de la grid.
     * @param event
     */
    @FXML
    private void tableViewDoubleClick(MouseEvent event)
    {
        if(event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2)
        {
            switch (selectionModel.getSelectedIndex())
            {
                case 1 :
                    try
                    {
                        Client client = tableViewClients.getSelectionModel().getSelectedItem();
                        customerWindowController.set_selectedClient(client);
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("customerWindow.fxml"));
                        Parent root1 = fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.setTitle(client.get_prenomClient() + " " + client.get_nameClient());
                        stage.setScene(new Scene(root1));
                        stage.show();
                    }
                    catch(IOException e)
                    {
                        e.printStackTrace();
                    }
                    break;

                case 4 :
                    try
                    {
                        Accompagnateur accompagnateur = tableViewAccompagnateurs.getSelectionModel().getSelectedItem();
                        guideWindowController.set_selectedAccompagnateur(accompagnateur);
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("guideWindow.fxml"));
                        Parent root1 = fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.setTitle(accompagnateur.get_prenomAccompagnateur()+" "+accompagnateur.get_nameAccompagnateur());
                        stage.setScene(new Scene(root1));
                        stage.show();
                    }
                    catch(IOException e)
                    {
                        e.printStackTrace();
                    }
                    break;

                default:
                    break;
            }
        }
    }

    //endregion FXML

    /**
     * Chargement du contenu des tables de la base de donnée
     */
    private void LoadTables()
    {
        // 1. Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<Circuit> filteredCircuitData = new FilteredList<>(TableManager.Instance().LoadCircuits(), p -> true);
        FilteredList<Client> filteredClientData = new FilteredList<>(TableManager.Instance().LoadClients(), p -> true);
        FilteredList<Hotel> filteredHotelData = new FilteredList<>(TableManager.Instance().LoadHotels(), p -> true);
        FilteredList<Ville> filteredVilleData = new FilteredList<>(TableManager.Instance().LoadVilles(), p -> true);
        FilteredList<Accompagnateur> filteredAccompagnateurData = new FilteredList<>(TableManager.Instance().LoadAccompagnateurs(), p -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        textFieldRequete.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredCircuitData.setPredicate(Circuit -> {
                // If filter text is empty, display all Circuits.
                if (newValue == null || newValue.isEmpty())
                {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (Circuit.get_nameCircuit().toLowerCase().contains(lowerCaseFilter))
                {
                    return true; // Filter matches name.
                }
                return false; // Does not match.
            });
        });

        textFieldRequete.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredClientData.setPredicate(Client -> {
                // If filter text is empty, display all Circuits.
                if (newValue == null || newValue.isEmpty())
                {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (Client.get_nameClient().toLowerCase().contains(lowerCaseFilter))
                {
                    return true; // Filter matches name.
                }
                else if (Client.get_prenomClient().toLowerCase().contains(lowerCaseFilter))
                {
                    return true; // Filter matches name.
                }
                return false; // Does not match.
            });
        });

        textFieldRequete.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredHotelData.setPredicate(Hotel -> {
                // If filter text is empty, display all Circuits.
                if (newValue == null || newValue.isEmpty())
                {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (Hotel.get_nameHotel().toLowerCase().contains(lowerCaseFilter))
                {
                    return true; // Filter matches name.
                }
                return false; // Does not match.
            });
        });

        textFieldRequete.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredVilleData.setPredicate(Ville -> {
                // If filter text is empty, display all Circuits.
                if (newValue == null || newValue.isEmpty())
                {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (Ville.get_nameVille().toLowerCase().contains(lowerCaseFilter))
                {
                    return true; // Filter matches name.
                }
                return false; // Does not match.
            });
        });

        textFieldRequete.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredAccompagnateurData.setPredicate(Accompagnateur -> {
                // If filter text is empty, display all Circuits.
                if (newValue == null || newValue.isEmpty())
                {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (Accompagnateur.get_nameAccompagnateur().toLowerCase().contains(lowerCaseFilter))
                {
                    return true; // Filter matches name.
                }
                else if(Accompagnateur.get_prenomAccompagnateur().toLowerCase().contains(lowerCaseFilter))
                {
                    return true;
                }
                return false; // Does not match.
            });
        });

        // 3. Wrap the FilteredList in a SortedList.
        SortedList<Circuit> sortedCircuitData = new SortedList<>(filteredCircuitData);
        SortedList<Client> sortedClientData = new SortedList<>(filteredClientData);
        SortedList<Hotel> sortedHotelData = new SortedList<>(filteredHotelData);
        SortedList<Ville> sortedVilleData = new SortedList<>(filteredVilleData);
        SortedList<Accompagnateur> sortedAccompagnateurData = new SortedList<>(filteredAccompagnateurData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        sortedCircuitData.comparatorProperty().bind(tableViewCircuits.comparatorProperty());
        sortedClientData.comparatorProperty().bind(tableViewClients.comparatorProperty());
        sortedHotelData.comparatorProperty().bind(tableViewHotels.comparatorProperty());
        sortedVilleData.comparatorProperty().bind(tableViewVilles.comparatorProperty());
        sortedAccompagnateurData.comparatorProperty().bind(tableViewAccompagnateurs.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        this.tableViewCircuits.setItems(sortedCircuitData);
        this.tableViewClients.setItems(sortedClientData);
        this.tableViewHotels.setItems(sortedHotelData);
        this.tableViewVilles.setItems(sortedVilleData);
        this.tableViewAccompagnateurs.setItems(sortedAccompagnateurData);

        this.tableViewReservations.setItems(TableManager.Instance().LoadReservations());

        this.selectionModel = this.tabPaneMain.getSelectionModel();
    }

    //endregion Private Services
}
