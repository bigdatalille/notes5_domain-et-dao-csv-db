--
-- Structure de la table `site_translation`
--

CREATE TABLE IF NOT EXISTS `eleve` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nom` varchar(100) DEFAULT NULL,
  `prenom` varchar(100) DEFAULT NULL,
  `classe` int(10) unsigned NOT NULL,
  `date_naissance` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `adresse` varchar(250) DEFAULT NULL,
  `sexe` enum('HOMME','FEMME') NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;
