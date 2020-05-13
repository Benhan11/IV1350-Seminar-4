# IV1350-Seminar-4
Updated version of seminar 3 program including exceptions and implementation of design patterns. Part of the course IV1350.

The new Exceptions are:
processSale.controller.OperationFailedException
processSale.integration.InvalidItemIdentifierException
processSale.integration.InventorySystemException
processSale.model.InvalidItemDTOException
processSale.model.InvalidQuantityException
processSale.view.ErrorHandler
processSale.view.LogHandler

Observer pattern relevant classes:
processSale.view.TotalRevenueView
processSale.model.TransactionObserver
Used in:
processSale.view.View
processSale.controller.Controller
processSale.model.Sale

Simpleton pattern relevant classes:
processSale.integration.DBHandler

Strategy pattern relevant classes (Discount functionality):
processSale.controller.Controller
processSale.integration.DiscountFinder
processSale.integration.ItemSpecialsDiscountFinder
processSale.integration.SalePriceDiscountFinder
processSale.integration.Discount

The error log (error_log.txt) is outside of /src
