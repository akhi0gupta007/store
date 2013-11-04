
// Global vars to hold the object in the panel.
tabPanelArray = new Array(3);
tabMenuArray = new Array(3);
currentMenuIndex = 0;

/**
 * This MUST be called on page load to fill up the shared global values.
 * Having the panes object accessible by index makes things easier.
 * This is also a good place to display the first page.
 */
function bodyOnLoad()
   {
   tabPanelArray[0] = getItemObj('tabPane0');
   tabPanelArray[1] = getItemObj('tabPane1');
   tabPanelArray[2] = getItemObj('tabPane2');

   tabMenuArray[0] = getItemObj('tabMenu0');
   tabMenuArray[1] = getItemObj('tabMenu1');
   tabMenuArray[2] = getItemObj('tabMenu2');

   raisePanel ( currentMenuIndex );
   }

/**
 * Utility function just to show an error if I try to get non existen objects
 */
function getItemObj ( itemId )
   {
   obj = document.getElementById(itemId);

   if ( obj == null ) alert('Script Error: id='+itemId+' does not exist');

   return obj;
   }


/**
 * raising a panel means setting all the other panels to a lower level
 * and setting the raided panel to a higher level
 * note that also the size must be set correctly !
 * to activate a menu i switch the class between active and not active.
 */
function raisePanel ( panelIndex )
   {
   for (index=0; index<3; index++ )
      {
      // the panel with the index == wantedIndex gets raised.
      if (index == panelIndex )
         {
         raiseObject (tabPanelArray[index], 4);
         tabMenuArray[index].className = 'tabMenuActive';
         }
      else
         {
         raiseObject (tabPanelArray[index], 2);
         tabMenuArray[index].className = 'tabMenu';
         }
      }

   currentMenuIndex=panelIndex;

   return true;
   }

/**
 * When I raise a panel I may as well check for the correct size and fix it.
 * it is a bit of doubling work, but it does not happens often !
 */
function raiseObject ( target, level )
   {
   /* the number of pixels we shave to the outside filler to fit everything in
    * this value depends on the border set for the filler div and possible padding
    * it is best to experiment a bit with it.
    */
   safeMargin = 6;

   // the size of the panels depends on the size of the tabFiller
   obj = getItemObj('tabFiller');

   newWidth = obj.offsetWidth - safeMargin;
   if ( newWidth < safeMargin ) newWidth = safeMargin;
   target.style.width = newWidth+'px';

   newHeight =obj.offsetHeight - safeMargin;
   if ( newHeight < safeMargin ) newHeight = safeMargin;
   target.style.height = newHeight+'px';

   // setting the z-index last should optimize possible resize.
   target.style.zIndex=level;
   }

/**
 * When we mouse out of the span we restore the class to the default value
 * But this only if we are not over the current selected menu
 */
function mouseOut ( menuIndex )
   {
   if ( menuIndex == currentMenuIndex ) return true;

   tabMenuArray[menuIndex].className = 'tabMenu';
   }

/**
 * When we mouse over of the span we set the class of the span to the over one
 * But this only if we are not over the current selected menu
 */
function mouseOver ( menuIndex )
   {
   if ( menuIndex == currentMenuIndex ) return true;

   tabMenuArray[menuIndex].className = 'tabMenuOver';
   }
