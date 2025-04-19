package model;

import java.beans.PropertyChangeListener;

//interface for observer pattern
public interface PropertyChangeSubject
{
  void addPropertyChangeListener(PropertyChangeListener listener);

  void addPropertyChangeListener(String propertyName, PropertyChangeListener listener);

  void removePropertyChangeListener(PropertyChangeListener listener);

  void removePropertyChangeListener(String propertyName, PropertyChangeListener listener);
}