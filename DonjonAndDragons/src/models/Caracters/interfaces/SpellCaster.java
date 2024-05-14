package DonjonAndDragons.src.models.Caracters.interfaces;

import DonjonAndDragons.src.models.Caracters.Caracter;

public interface SpellCaster {
    public int castSpell(Caracter target);
    public void castHealingSpell();
}
